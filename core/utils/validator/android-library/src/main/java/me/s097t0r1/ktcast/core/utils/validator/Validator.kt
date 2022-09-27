package me.s097t0r1.ktcast.core.utils.validator

interface Validator<T> {

    fun validate(input: T): ValidationResult

    fun interface Rule<T> {
        fun match(input: T): Boolean
    }

    interface Operator {
        fun concat(results: List<ValidationResult>): ValidationResult
    }
}