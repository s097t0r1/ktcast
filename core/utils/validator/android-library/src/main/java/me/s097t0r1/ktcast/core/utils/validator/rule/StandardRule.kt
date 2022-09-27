package me.s097t0r1.ktcast.core.utils.validator.rule

import me.s097t0r1.ktcast.core.utils.validator.Validator

object Standard {

    class LengthRule(
        private val minLength: Int = Int.MIN_VALUE,
        private val maxLength: Int = Int.MAX_VALUE
    ) : Validator.Rule<String> {
        override fun match(input: String): Boolean {
            return input.length in minLength..maxLength
        }
    }

    class RegexRule(
        private val regex: Regex
    ) : Validator.Rule<String> {

        override fun match(input: String): Boolean {
            return regex.matches(input)
        }

        companion object {
            const val EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
        }
    }
}