package me.s097t0r1.ktcast.feature.authorization.screens.lets_you_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.s097t0r1.core.ui_components.components.KtCastPrimaryButton
import me.s097t0r1.core.ui_components.theme.KtCastColorPallete
import me.s097t0r1.core.ui_components.theme.KtCastTheme
import me.s097t0r1.ktcast.feature.authorization.widget.DividerWithText
import me.s097t0r1.ktcast.feature.authorization.widget.SocialButton

@Composable
fun LetsYouInScreen(
    modifier: Modifier = Modifier,
    onSignUpClicked: () -> Unit,
    onSignInClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_lets_you_in_logo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_lets_you_in),
            style = KtCastTheme.typography.Heading1
        )
        Spacer(modifier = Modifier.height(30.dp))
        SignInButtons()
        DividerWithText(
            modifier = Modifier.padding(vertical = 32.dp),
            text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_or_divider)
        )
        KtCastPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSignInClicked,
            shape = RoundedCornerShape(100.dp)
        ) {
            Text(
                text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_sign_in_with_password)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        SignUpRecomendation(
            onSignUpClicked = onSignUpClicked
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
private fun SignInButtons() {
    SocialButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(vertical = 19.dp)
    ) {
        Image(
            painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_facebook),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_continue_with_facebook)
        )
    }
    Spacer(Modifier.height(19.dp))
    SocialButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(vertical = 19.dp)
    ) {
        Image(
            painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_google),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_continue_with_google)
        )
    }
    Spacer(Modifier.height(19.dp))
    SocialButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(vertical = 19.dp)
    ) {
        Image(
            painter = painterResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.drawable.ic_auth_feature_apple),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_continue_with_apple)
        )
    }
}

@Composable
private fun SignUpRecomendation(modifier: Modifier = Modifier, onSignUpClicked: () -> Unit) {

    val annotatedRecomendation = buildAnnotatedSignUpRecomendation()

    ClickableText(text = annotatedRecomendation, onClick = {
        annotatedRecomendation
            .getStringAnnotations("SignUp", it, it)
            .firstOrNull()?.let {
                onSignUpClicked()
            }
    })
}

@Composable
private fun buildAnnotatedSignUpRecomendation() = buildAnnotatedString {
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
        append(stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_dont_have_an_account))
        append(' ')
    }
    withStyle(textSpanStyle.copy(color = KtCastTheme.colors.primaryColor)) {
        pushStringAnnotation("SignUp", "SignUp")
        append(stringResource(id = me.s097t0r1.ktcast.feature.authorization.res.R.string.auth_feature_sign_up))
        pop()
    }
}

@Preview
@Composable
fun LetsYouInPreview() {
    KtCastTheme(isDarkTheme = true) {
        LetsYouInScreen(Modifier, {}, {})
    }
}