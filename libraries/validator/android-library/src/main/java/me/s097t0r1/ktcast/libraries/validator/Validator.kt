package me.s097t0r1.ktcast.libraries.validator

interface Validator<T> {

    fun validate(input: T): ValidationResult

    fun setOnValidateListener(listener: Listener?)

    fun interface Rule<T> {
        fun match(input: T): Boolean
    }

    interface Operator {
        fun concat(results: List<ValidationResult>): ValidationResult
    }

    fun interface Listener {
        fun onValidate(result: ValidationResult)
    }
}