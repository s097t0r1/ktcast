package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up

import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.ktcast.feature.authorization.impl.domain.SignUpInteractor
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation.SignUpNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.EmailFieldState
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpUIState
import me.s097t0r1.ktcast.libraries.either.fold
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider
import me.s097t0r1.ktcast.libraries.validator.DefaultValidator
import me.s097t0r1.ktcast.libraries.validator.ext.asFlow
import me.s097t0r1.ktcast.libraries.validator.operators.AndOperator
import me.s097t0r1.ktcast.libraries.validator.rule.Standard
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class SignUpViewModel @Inject constructor(
    private val interactor: SignUpInteractor,
    resourceProvider: ResourceProvider
) : BaseViewModel<SignUpUIState, SignUpSideEffect, SignUpNavigationGraph>() {

    override val container = container<SignUpUIState, SignUpSideEffect>(SignUpUIState())

    private val emailValidator = DefaultValidator.Builder<String>()
        .addRule(
            resourceProvider.getString(me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_invalid_email_format),
            Standard.RegexRule(
                Regex(
                    Standard.RegexRule.EMAIL_ADDRESS_REGEX,
                    RegexOption.IGNORE_CASE
                )
            )
        )
        .setOperator(AndOperator())
        .build()

    private val passwordValidator = DefaultValidator.Builder<String>()
        .addRule(resourceProvider.getString(me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_invalid_password_format), Standard.RegexRule(PASSWORD_REGEX))
        .setOperator(AndOperator())
        .build()

    fun onInitViewModel() {
        combineValidators()
    }

    private fun combineValidators() = combine(
        emailValidator.asFlow(),
        passwordValidator.asFlow()
    ) { arr -> arr.fold(false) { acc, res -> acc or res.isError } }
        .distinctUntilChanged()
        .onEach { hasError ->
            intent {
                reduce { state.copy(isSignUpEnabled = !hasError) }
            }
        }
        .launchIn(viewModelScope)

    fun onEmailChanged(email: String) = intent {
        reduce {
            val (isError, errorMsg) = emailValidator.validate(email)
            state.copy(
                emailField = EmailFieldState(
                    isError = isError,
                    errorMsg = errorMsg,
                    value = email
                )
            )
        }
    }

    fun onPasswordChanged(password: String) = intent {
        reduce {
            val (isError, errorMsg) = passwordValidator.validate(password)
            state.copy(
                passwordField = state.passwordField.copy(
                    isError = isError,
                    errorMsg = errorMsg,
                    value = password
                )
            )
        }
    }

    fun onToggleMaskPassword(isEnabled: Boolean) = intent {
        reduce {
            state.copy(
                passwordField = state.passwordField.copy(
                    isMaskEnabled = isEnabled
                )
            )
        }
    }

    fun onSignUpClicked() = intent {
        interactor.signUp(
            state.emailField.value,
            state.passwordField.value
        ).fold(
            onSuccess = { navigateTo(SignUpNavigationGraph.FillProfileScreen) },
            onFailure = ::onError
        )
    }

    fun onSignInClicked() = navigateTo(SignUpNavigationGraph.SignInScreen)

    companion object {
        private val PASSWORD_REGEX = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    }
}