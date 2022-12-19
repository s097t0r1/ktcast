package me.s097t0r1.ktcast.feature.authorization.screens.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.s097t0r1.core.ui_components.components.KtCastCheckbox
import me.s097t0r1.core.ui_components.components.KtCastOutlinedTextField
import me.s097t0r1.core.ui_components.components.KtCastPrimaryButton
import me.s097t0r1.core.ui_components.theme.KtCastColorPallete
import me.s097t0r1.core.ui_components.theme.KtCastTheme
import me.s097t0r1.ktcast.feature.authorization.widget.DividerWithText
import me.s097t0r1.ktcast.feature.authorization.widget.SocialButton

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    state: SignUpUIState,
    onEmailChanged: (String) -> Unit,
    onPasswordChaged: (String) -> Unit,
    onRememberCheckedChange: (Boolean) -> Unit,
    onSignUpClicked: () -> Unit,
    onSignedInClicked: () -> Unit,
    onToggleMaskPassword: (Boolean) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(44.dp))

        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = me.s097t0r1.core.ui_components.res.R.drawable.ic_ktcast_logo),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(44.dp))

        Text(
            text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_create_your_account),
            style = KtCastTheme.typography.Heading3.copy(fontWeight = FontWeight.Bold),
        )

        Spacer(modifier = Modifier.height(44.dp))

        SignUpForm(
            emailFieldState = state.emailField,
            onEmailChanged = onEmailChanged,
            passwordFieldState = state.passwordField,
            onPasswordChaged = onPasswordChaged,
            isRememberUser = state.isRemeberChecked,
            onRememberCheckedChange = onRememberCheckedChange,
            isSignUpEnabled = state.isSignUpEnabled,
            onSignUpClicked = onSignUpClicked,
            onToggleMaskPassword = onToggleMaskPassword,
        )

        Spacer(modifier = Modifier.height(43.dp))

        AlternativeRegistrationMethods(
            onGoogleClicked = {},
            onFacebookClicked = {},
            onAppleClicked = {}
        )

        SignInRecomendation(
            modifier = Modifier.padding(44.dp),
            onSignInClicked = onSignedInClicked
        )
    }
}

@Composable
fun SignInRecomendation(
    modifier: Modifier = Modifier,
    onSignInClicked: () -> Unit
) {
    val recomendation = buildAnnotatedSignInRecomendation()
    ClickableText(
        modifier = modifier,
        text = recomendation,
        onClick = {
            recomendation.getStringAnnotations(it, it).firstOrNull()?.let {
                onSignInClicked()
            }
        })
}

@Composable
private fun buildAnnotatedSignInRecomendation() = buildAnnotatedString {
    val textSpanStyle = SpanStyle(
        color = if (KtCastTheme.colors.isLight) {
            KtCastColorPallete.grayScale500Color
        } else {
            KtCastColorPallete.otherWhiteColor
        },
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
    withStyle(textSpanStyle) {
        append(stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_already_have_an_account))
        append(' ')
    }
    withStyle(textSpanStyle.copy(color = KtCastTheme.colors.primaryColor)) {
        pushStringAnnotation(
            stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_sign_in),
            stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_sign_in),
        )
        append(stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_sign_in))
        pop()
    }
}

@Composable
private fun AlternativeRegistrationMethods(
    onGoogleClicked: () -> Unit,
    onFacebookClicked: () -> Unit,
    onAppleClicked: () -> Unit,
) {
    DividerWithText(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_or_continue_with)
    )
    Spacer(modifier = Modifier.height(30.dp))
    Row {
        SocialButton(
            onClick = onFacebookClicked,
            contentPadding = PaddingValues(
                vertical = 18.dp,
                horizontal = 32.dp
            )
        ) {
            Image(
                painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_facebook),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        SocialButton(
            onClick = onGoogleClicked,
            contentPadding = PaddingValues(
                vertical = 18.dp,
                horizontal = 32.dp
            )
        ) {
            Image(
                painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_google),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        SocialButton(
            onClick = onAppleClicked,
            contentPadding = PaddingValues(
                vertical = 18.dp,
                horizontal = 32.dp
            )
        ) {
            Image(
                painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_apple),
                contentDescription = null
            )
        }
    }

}

@Composable
private fun SignUpForm(
    emailFieldState: EmailFieldState,
    onEmailChanged: (String) -> Unit,
    passwordFieldState: PasswordFieldState,
    onPasswordChaged: (String) -> Unit,
    isRememberUser: Boolean,
    onRememberCheckedChange: (Boolean) -> Unit,
    isSignUpEnabled: Boolean,
    onSignUpClicked: () -> Unit,
    onToggleMaskPassword: (Boolean) -> Unit
) {
    Column {
        KtCastOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = emailFieldState.value,
            isError = emailFieldState.isError,
            errorText = emailFieldState.errorMsg,
            onValueChange = onEmailChanged,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_mail),
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            placeholder = { Text(text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_email_address_placeholder)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        KtCastOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordFieldState.value,
            isError = passwordFieldState.isError,
            errorText = passwordFieldState.errorMsg,
            onValueChange = onPasswordChaged,
            visualTransformation = if (passwordFieldState.isMaskEnabled) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_lock),
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconToggleButton(
                    checked = passwordFieldState.isMaskEnabled,
                    onCheckedChange = onToggleMaskPassword
                ) {
                    Icon(
                        painter = painterResource(
                            if (passwordFieldState.isMaskEnabled) {
                                me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_hide
                            } else {
                                me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_show
                            }
                        ),
                        contentDescription = null
                    )
                }
            },
            placeholder = { Text(text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_password_placeholder)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            KtCastCheckbox(
                checked = isRememberUser,
                onCheckedChange = onRememberCheckedChange
            )
            Text(
                text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_remeber_me),
                style = KtCastTheme.typography.BodyMedium.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        KtCastPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSignUpClicked,
            enabled = isSignUpEnabled,
            shape = RoundedCornerShape(100.dp)
        ) {
            Text(
                stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_sign_up),
                style = KtCastTheme.typography.BodyLarge
                    .copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen(
        state = SignUpUIState(),
        onEmailChanged = {},
        onPasswordChaged = {},
        onRememberCheckedChange = {},
        onSignUpClicked = {},
        onSignedInClicked = {},
        onToggleMaskPassword = {}
    )
}

@Preview
@Composable
private fun SignUpScreenDarkPreview() {
    KtCastTheme(isDarkTheme = true) {
        SignUpScreen(
            state = SignUpUIState(),
            onEmailChanged = {},
            onPasswordChaged = {},
            onRememberCheckedChange = {},
            onSignUpClicked = {},
            onSignedInClicked = {},
            onToggleMaskPassword = {}
        )
    }

}