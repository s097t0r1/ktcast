package me.s097t0r1.deps_holder_processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import java.io.BufferedWriter

internal class DHProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
    private val metaInfo: MetaInfoProccessor
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        logger.warn("Processing...")
        val ret = resolver.getSymbolsWithAnnotation(ComponentHolder::class.qualifiedName!!)
        val baseFiles: MutableList<Int> = mutableListOf()
        ret.forEach {
            it.accept(DependencyHolderVisitor(codeGenerator, logger, metaInfo, baseFiles), Unit)
        }

        return ret.toList()
    }
}

class DependencyHolderVisitor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
    private val codeGeneratorMetaInfo: MetaInfoProccessor,
    private val files: MutableList<Int>
) : KSVisitorVoid() {

    override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
        logger.info("Visit", function)
        val numberOfComponents = function.annotations
            .find { it.shortName.getShortName() == "ComponentHolder" }
            ?.arguments
            ?.get(0)
            ?.value as? Int ?: run {
            logger.error("Cannot find numberOfComponents", function)
            return
        }

        logger.warn("Number of components: $numberOfComponents", function)
        val fileName = "DependencyHolder$numberOfComponents"

        if (files.contains(numberOfComponents)) return

        logger.warn(codeGenerator.generatedFile.toString())
        try {
            codeGenerator.createNewFile(
                Dependencies(false),
                codeGeneratorMetaInfo.packageLocation,
                fileName
            ).bufferedWriter()
                .createDependencyHolder(numberOfComponents, codeGeneratorMetaInfo)
                .close()
        } catch (e: FileAlreadyExistsException) {
            return
        }
    }

    private fun isDuplicatedFile(fileName: String): Boolean =
        codeGenerator.generatedFile.any { it.nameWithoutExtension == fileName }

    private fun BufferedWriter.createDependencyHolder(
        numberOfComponents: Int,
        metaInfo: MetaInfoProccessor
    ): BufferedWriter {
        appendImports(
            metaInfo.packageLocation,
            metaInfo.baseFeatureDependencyPackage,
            metaInfo.baseFeatureApiPackage,
            metaInfo.baseDependencyHolderPackage
        )
        appendClassDeclaration(numberOfComponents)
        appendBodyClass(numberOfComponents)
        return this
    }

    private fun BufferedWriter.appendBodyClass(numberOfComponents: Int) {
        appendLine()
        appendLine("abstract val block: (")
        for (i in 0 until numberOfComponents) {
            appendLine("A$i,")
        }
        appendLine("BaseDependencyHolder<D>) -> D")
        appendLine()
        appendLine("val dependencies: D get() = block(")
        for (i in 0 until numberOfComponents) {
            appendLine("a$i,")
        }
        appendLine("this")
        appendLine(")")
        appendLine()
        addFactoryMethod(numberOfComponents)
        appendLine("}")
    }

    private fun BufferedWriter.addFactoryMethod(numberOfComponents: Int) {
        appendLine("companion object {")
        appendLine("fun <D : BaseFeatureDepenendencies,")
        for (i in 0 until numberOfComponents) {
            appendLine("A$i : BaseFeatureAPI,")
        }
        appendLine("> create(")
        for (i in 0 until numberOfComponents) {
            appendLine("a$i: A$i,")
        }
        append("block: (")
        for (i in 0 until numberOfComponents) {
            append("A$i,")
        }
        appendLine("BaseDependencyHolder<D>) -> D")
        append("): D = object : BaseDependencyHolder$numberOfComponents<")
        for (i in 0 until numberOfComponents) {
            append("A$i,")
        }
        appendLine("D>(")
        for (i in 0 until numberOfComponents) {
            appendLine("a$i = a$i,")
        }
        appendLine(") {")
        appendLine("override val block: (")
        for (i in 0 until numberOfComponents) {
            appendLine("A$i,")
        }
        appendLine("BaseDependencyHolder<D>)")
        appendLine(" -> D = block")
        appendLine("}.dependencies")
        appendLine("}")
    }

    private fun BufferedWriter.appendClassDeclaration(numberOfComponents: Int) {
        appendLine("abstract class BaseDependencyHolder$numberOfComponents<")
        for (i in 0 until numberOfComponents) {
            appendLine("A$i : BaseFeatureAPI,")
        }
        appendLine("D : BaseFeatureDepenendencies>(")
        for (i in 0 until numberOfComponents) {
            appendLine("private val a$i: A$i,")
        }
        appendLine(") : BaseDependencyHolder<D>() {")
    }

    private fun BufferedWriter.appendImports(
        packageLocation: String,
        baseFeatureApi: String,
        baseFeatureDependency: String,
        baseClassLocation: String
    ) {
        append("package ")
        appendLine(packageLocation)
        appendLine()
        append("import ")
        appendLine(baseFeatureApi)
        append("import ")
        appendLine(baseFeatureDependency)
        appendLine()
        append("import ")
        appendLine(baseClassLocation)
    }
}
