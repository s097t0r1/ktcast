package me.s097t0r1.deps_holder_processor

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File

class DHProcessorProvider : SymbolProcessorProvider {

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return DHProcessor(
            environment.codeGenerator,
            environment.logger,
            moshi.adapter(MetaInfoProccessor::class.java).fromJson(
                File(
                    environment.options["jsonConfigurationFilePath"]
                        ?: error("Configuration file path not specified")
                ).bufferedReader().readText()
            ) ?: error("Cannot read json configurartion file")
        )
    }
}
