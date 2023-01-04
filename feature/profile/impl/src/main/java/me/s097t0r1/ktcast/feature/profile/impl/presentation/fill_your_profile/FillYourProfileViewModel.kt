package me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile

import android.net.Uri
import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.ktcast.feature.profile.impl.R
import me.s097t0r1.ktcast.feature.profile.impl.domain.FillYourProfileInteractor
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.navigation.FillYourProfileNavGraph
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileSideEffect
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileUIState
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.StringFieldState
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider
import me.s097t0r1.ktcast.libraries.validator.DefaultValidator
import me.s097t0r1.ktcast.libraries.validator.ext.asFlow
import me.s097t0r1.ktcast.libraries.validator.operators.AndOperator
import me.s097t0r1.ktcast.libraries.validator.rule.Standard
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class FillYourProfileViewModel @Inject constructor(
    private val resProvider: ResourceProvider,
    private val interactor: FillYourProfileInteractor
) : BaseViewModel<FillYourProfileUIState, FillYourProfileSideEffect, FillYourProfileNavGraph>() {

    private val fullNameValidator = DefaultValidator.Builder<String>()
        .addRule(
            resProvider.getString(R.string.profile_feat_incorrect_full_name),
            Standard.RegexRule(Regex(FULL_NAME_REGEX))
        )
        .setOperator(AndOperator())
        .build()

    private val nicknameValidator = DefaultValidator.Builder<String>()
        .addRule(
            resProvider.getString(R.string.profile_feat_incorrect_full_name),
            Standard.RegexRule(Regex(NICKNAME_REGEX))
        )
        .setOperator(AndOperator())
        .build()

    private val emailValidator = DefaultValidator.Builder<String>()
        .addRule(
            resProvider.getString(R.string.profile_feat_incorrect_full_name),
            Standard.RegexRule(Regex(Standard.RegexRule.EMAIL_ADDRESS_REGEX))
        )
        .setOperator(AndOperator())
        .build()

    override val container: Container<FillYourProfileUIState, FillYourProfileSideEffect> =
        container(FillYourProfileUIState())

    fun onInitViewModel() {
        combineValidators()
    }

    private fun combineValidators() {
        combine(
            fullNameValidator.asFlow(),
            nicknameValidator.asFlow(),
            emailValidator.asFlow()
        ) { results -> results.all { !it.isError } }
            .onEach { intent { reduce { state.copy(isContinueEnabled = it) } } }
            .launchIn(viewModelScope)
    }

    fun onEditClick() = intent {
        postSideEffect(FillYourProfileSideEffect.OpenImagePicker)
    }

    fun onFullNameChange(fullName: String) = intent {
        fullNameValidator.validate(fullName).let { result ->
            reduce {
                state.copy(
                    fieldsState = state.fieldsState.copy(
                        fullNameField = StringFieldState(
                            isError = result.isError,
                            value = fullName,
                            errorMsg = result.errorMsg
                        )
                    )
                )
            }
        }
    }

    fun onNicknameChange(nickname: String) = intent {
        nicknameValidator.validate(nickname).let { result ->
            reduce {
                state.copy(
                    fieldsState = state.fieldsState.copy(
                        nicknameField = StringFieldState(
                            isError = result.isError,
                            value = nickname,
                            errorMsg = result.errorMsg
                        )
                    )
                )
            }
        }
    }

    fun onBirthdayChange(birthday: String) = intent {
        reduce {
            state.copy(
                fieldsState = state.fieldsState.copy(
                    birthDayField = StringFieldState(
                        value = birthday,
                    )
                )
            )
        }
    }

    fun onEmailChange(email: String) = intent {
        emailValidator.validate(email).let { result ->
            reduce {
                state.copy(
                    fieldsState = state.fieldsState.copy(
                        emailField = StringFieldState(
                            isError = result.isError,
                            value = email,
                            errorMsg = result.errorMsg
                        )
                    )
                )
            }
        }
    }

    fun onImageSelect(imageUri: Uri) = intent {
        reduce { state.copy(avatarUri = imageUri.toString()) }
    }

    companion object {
        private const val FULL_NAME_REGEX = "^([a-zA-Z]{2,}\\s[a-zA-Z]+'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]+)?)"
        private const val NICKNAME_REGEX = "^(^[^0-9])([\\w a-z A-Z 0-9][^@#])\$"
    }
}
