package me.s097t0r1.ktcast.feature.splash.widget.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.s097t0r1.core.ui_components.theme.KtCastColors
import me.s097t0r1.core.ui_components.theme.KtCastTheme
import me.s097t0r1.ktcast.feature.splash.widget.R

@Composable
fun SplashScreen() {
    Surface(
        color = KtCastTheme.colors.backgroundPrimaryColor
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_ktcast_logo),
                    contentDescription = "Logo"
                )
                Text(
                    text = stringResource(id = R.string.splash_feature_app_name),
                    color = KtCastTheme.colors.textPrimaryColor,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = KtCastTheme.typography.boldStyle,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    KtCastTheme { SplashScreen() }
}