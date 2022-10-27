package me.s097t0r1.ktcast.feature.splash.widget.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.s097t0r1.core.ui_components.theme.KtCastTheme
import me.s097t0r1.ktcast.feature.splash.widget.R
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashSideEffect
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashUIState

@Composable
fun SplashScreen(
    state: SplashUIState,
    effect: SplashSideEffect
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_ktcast_logo),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.width(16.dp))
            AnimatedVisibility(
                visible = state.isAppNameVisible,
                enter = expandHorizontally(),
                exit = shrinkHorizontally()
            ) {
                Text(
                    text = stringResource(id = R.string.splash_feature_app_name),
                    color = KtCastTheme.colors.textPrimaryColor,
                    style = KtCastTheme.typography.heading1,
                )
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    KtCastTheme { SplashScreen(SplashUIState(true), SplashSideEffect()) }
}
