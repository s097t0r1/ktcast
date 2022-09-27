package me.s097t0r1.ktcast.feature.authorization.screens.sign_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.s097t0r1.core.ui_components.components.KtCastOutlinedTextField
import me.s097t0r1.core.ui_components.theme.KtCastTheme
import me.s097t0r1.ktcast.feature.authorization.screens.R

@Composable
fun SignInScreen(
    state: SignInUIState,
    sideEffect: SignInSideEffect,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit
) {
    ImageBackground(
        painter = painterResource(id = R.drawable.ic_authorization_background)
    ) {
        Column(modifier = Modifier.padding(horizontal = 32.dp)) {
            Logo(modifier = Modifier.padding(top = 52.dp))
            Text(
                modifier = Modifier.padding(top = 48.dp),
                text = stringResource(id = R.string.authorization_feature_sign_in_title),
                style = KtCastTheme.typography.mediumStyle,
                color = KtCastTheme.colors.textPrimaryColor,
                fontSize = 24.sp
            )
            SignInForm(
                state.emailField, onEmailChanged,
                state.passwordFieldState, onPasswordChanged
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.authorization_feature_forgot_password),
                textDecoration = TextDecoration.Underline,
                color = KtCastTheme.colors.textSecondaryColor,
            )
        }
    }
}

@Composable
private fun SignInForm(
    emailFieldState: EmailFieldState,
    onNewEmail: (String) -> Unit,
    passwordFieldState: PasswordFieldState,
    onNewPassword: (String) -> Unit
) {
    KtCastOutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 72.dp),
        value = emailFieldState.value,
        onValueChange = onNewEmail,
        label = { Text(text = stringResource(id = R.string.authorization_feature_email_address_placeholder)) },
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(horizontal = 24.dp),
                painter = painterResource(id = R.drawable.ic_authorization_mail),
                contentDescription = null
            )
        },
        isError = emailFieldState.isError,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
    KtCastOutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        value = passwordFieldState.value,
        onValueChange = onNewPassword,
        label = { Text(text = stringResource(id = R.string.authorization_feature_password_placeholder)) },
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(horizontal = 24.dp),
                painter = painterResource(id = R.drawable.ic_authorization_password),
                contentDescription = null
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        isError = passwordFieldState.isError
    )
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(100.dp),
                ambientColor = KtCastTheme.colors.buttonPrimaryColor,
                spotColor = KtCastTheme.colors.buttonPrimaryColor
            ),
        onClick = {},
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = KtCastTheme.colors.buttonPrimaryColor,
            contentColor = KtCastTheme.colors.textPrimaryColor,
        ),
        elevation = null
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = stringResource(id = R.string.authorization_feature_login_button),
        )
    }
}

@Composable
fun ImageBackground(painter: Painter, Content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = KtCastTheme.colors.backgroundPrimaryColor.copy(alpha = 0.9f)
        ) {
            Content()
        }
    }
}

@Composable
fun Logo(modifier: Modifier) {
    Row(modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_ktcast_logo),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(start = 14.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(id = R.string.authorization_feature_app_name),
            style = KtCastTheme.typography.boldStyle,
            fontSize = 24.sp,
            color = KtCastTheme.colors.textPrimaryColor
        )
    }
}

@Preview
@Composable
fun SignInPreview() {
    SignInScreen(state = SignInUIState(), sideEffect = SignInSideEffect(), {}, {})
}