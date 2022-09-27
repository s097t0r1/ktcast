package me.s097t0r1.ktcast.core.utils.validator.operators

import me.s097t0r1.ktcast.core.utils.validator.ValidationResult
import me.s097t0r1.ktcast.core.utils.validator.Validator

class AndOperator : Validator.Operator {

    override fun concat(results: List<ValidationResult>): ValidationResult {
        return results.reduce { acc, validationResult ->
            ValidationResult(
                isError = acc.isError or validationResult.isError,
                errorMsg = if (acc.isError) acc.errorMsg else validationResult.errorMsg
            )
        }
    }
}