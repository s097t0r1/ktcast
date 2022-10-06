package me.s097t0r1.ktcast.libraries.validator

import me.s097t0r1.ktcast.libraries.validator.operators.AndOperator

class DefaultValidator<T> internal constructor() : Validator<T> {

    private var listener: Validator.Listener? = null

    var ruleSet: Set<Pair<Validator.Rule<T>, String>> = emptySet()
    var operator: Validator.Operator = AndOperator()

    override fun setOnValidateListener(listener: Validator.Listener?) {
        this.listener = listener
    }

    override fun validate(input: T): ValidationResult {
        val results = ruleSet.map { (rule, errorMsg) ->
            ValidationResult(
                isError = !rule.match(input),
                errorMsg = errorMsg
            )
        }
        return operator.concat(results).also {
            listener?.onValidate(it)
        }
    }

    class Builder<T>() {

        private val ruleSet: MutableSet<Pair<Validator.Rule<T>, String>> = mutableSetOf()
        private var operator: Validator.Operator? = null

        fun addRule(errorMsg: String, rule: Validator.Rule<T>): Builder<T> {
            ruleSet.add(rule to errorMsg).also { return this }
        }

        fun setOperator(newOperator: Validator.Operator): Builder<T> {
            operator = newOperator
            return this
        }

        fun build() = DefaultValidator<T>().apply {
            ruleSet = HashSet(this@Builder.ruleSet)
            operator = requireNotNull(this@Builder.operator)
        }.also { this@Builder.clean() }

        private fun clean() {
            ruleSet.clear()
            operator = null
        }

    }
}