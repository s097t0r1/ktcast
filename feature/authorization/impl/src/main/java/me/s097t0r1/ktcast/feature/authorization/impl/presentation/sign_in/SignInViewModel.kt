package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in

import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.ktcast.feature.authorization.impl.domain.SignInInteractor
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation.SignInNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.EmailFieldState
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInUIState
import me.s097t0r1.ktcast.libraries.either.fold
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider
import me.s097t0r1.ktcast.libraries.validator.DefaultValidator
import me.s097t0r1.ktcast.libraries.validator.Validator
import me.s097t0r1.ktcast.libraries.validator.ext.asFlow
import me.s097t0r1.ktcast.libraries.validator.operators.AndOperator
import me.s097t0r1.ktcast.libraries.validator.rule.Standard
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class SignInViewModel @Inject constructor(
    resourceProvider: ResourceProvider,
    private val interactor: SignInInteractor
) : BaseViewModel<SignInUIState, SignInSideEffect, SignInNavigationGraph>() {

    override val container: Container<SignInUIState, SignInSideEffect> = container(SignInUIState())

    private val emailValidator: Validator<String> = DefaultValidator.Builder<String>()
        .addRule(
            resourceProvider.getString(me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_incorrect_email),
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
        .addRule(
            resourceProvider.getString(me.s097t0r1.ktcast.feature.authorization.res.R.string.authorization_feature_incorrect_password),
            Standard.LengthRule(minLength = 1)
        )
        .setOperator(AndOperator())
        .build()

    fun onInitViewModel() {
        combineValidators()
    }

    @OptIn(FlowPreview::class)
    private fun combineValidators() = combine(
        emailValidator.asFlow(),
        passwordValidator.asFlow()
    ) { arr -> arr.all { !it.isError } }
        .debounce(100L)
        .onEach { intent { reduce { state.copy(isSignInEnabled = it) } } }
        .launchIn(viewModelScope)


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
        reduce {
            val (isError, errorMsg) = passwordValidator.validate(newPassword)
            state.copy(
                passwordField = state.passwordField.copy(
                    isError = isError,
                    errorMsg = errorMsg,
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
        interactor.signIn(state.emailField.value, state.passwordField.value)
            .fold(
                onSuccess = { navigateTo(SignInNavigationGraph.HomeScreen) },
                onFailure = {
                    reduce { state.copy(isSignInEnabled = false) }
                    onError(it)
                }
            )
    }
}