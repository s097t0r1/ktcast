package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.core.result.Err
import me.s097t0r1.core.result.Ok
import me.s097t0r1.ktcast.core.utils.resource_provider.ResourceProvider
import me.s097t0r1.ktcast.core.utils.validator.DefaultValidator
import me.s097t0r1.ktcast.core.utils.validator.ext.asFlow
import me.s097t0r1.ktcast.core.utils.validator.operators.AndOperator
import me.s097t0r1.ktcast.core.utils.validator.rule.Standard
import me.s097t0r1.ktcast.feature.authorization.impl.domain.SignUpInteractor
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation.SignUpNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.EmailFieldState
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpUIState
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val interactor: SignUpInteractor,
    private val resourceProvider: ResourceProvider
) : BaseViewModel<SignUpUIState, SignUpSideEffect, SignUpNavigationGraph>() {

    override val container = container<SignUpUIState, SignUpSideEffect>(SignUpUIState())

    private val emailValidator = DefaultValidator.Builder<String>()
        .addRule(
            "Stab",
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
        .addRule("Stab", Standard.RegexRule(PASSWORD_REGEX))
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
        val signUpReact = interactor.signUp(
            state.emailField.value,
            state.passwordField.value
        )
        when (signUpReact) {
            is Ok -> Log.d("$this@SignUpViewModel", "Success")
            is Err -> Log.d("this@SignUpViewModel", "Error")
        }
    }

    private fun signUp(login: String, password: String) = viewModelScope.launch {
        interactor.signUp(login, password)
    }

    companion object {
        private val PASSWORD_REGEX = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")
    }
}