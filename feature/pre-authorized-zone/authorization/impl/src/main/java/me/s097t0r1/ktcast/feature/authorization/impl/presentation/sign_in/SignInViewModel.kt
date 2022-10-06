package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in

import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.ktcast.feature.authorization.impl.R
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation.SignInNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.EmailFieldState
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInUIState
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider
import me.s097t0r1.ktcast.libraries.validator.DefaultValidator
import me.s097t0r1.ktcast.libraries.validator.Validator
import me.s097t0r1.ktcast.libraries.validator.operators.AndOperator
import me.s097t0r1.ktcast.libraries.validator.rule.Standard
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

internal class SignInViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider
) : BaseViewModel<SignInUIState, SignInSideEffect, SignInNavigationGraph>() {

    override val container: Container<SignInUIState, SignInSideEffect> = container(SignInUIState())

    private val emailValidator: Validator<String> = DefaultValidator.Builder<String>()
        .addRule(resourceProvider.getString(R.string.authorization_feature_incorrect_email), Standard.LengthRule(minLength = 6))
        .addRule(
            resourceProvider.getString(R.string.authorization_feature_incorrect_email),
            Standard.RegexRule(
                Regex(
                    Standard.RegexRule.EMAIL_ADDRESS_REGEX,
                    RegexOption.IGNORE_CASE
                )
            )
        )
        .setOperator(AndOperator())
        .build()

    private val passwordValidator: Validator<String> = DefaultValidator.Builder<String>()
        .addRule(resourceProvider.getString(R.string.authorization_feature_incorrect_password), Standard.LengthRule(minLength = 6))
        .setOperator(AndOperator())
        .build()

    fun onEmailChanged(email: String) = intent {
        val result = emailValidator.validate(email)
        reduce {
            state.copy(
                emailField = EmailFieldState(
                    isError = result.isError,
                    errorMsg = result.errorMsg,
                    value = email
                )
            )
        }
    }

    fun onPasswordChanged(newPassword: String) = intent {
        val validationResult = passwordValidator.validate(newPassword)
        reduce {
            state.copy(
                passwordField = state.passwordField.copy(
                    isError = validationResult.isError,
                    errorMsg = validationResult.errorMsg,
                    value = newPassword
                )
            )
        }
    }

    fun onToggleMaskPassword(isEnabled: Boolean) = intent {
        reduce {
            state.copy(
                passwordField = state.passwordField.copy(isMaskEnabled = isEnabled)
            )
        }
    }

    fun onSignUpClicked() = navigateTo(SignInNavigationGraph.SignUpScreen)

    fun onSignInClicked() = intent {

    }
}