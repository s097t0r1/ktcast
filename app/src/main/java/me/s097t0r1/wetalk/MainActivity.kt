package me.s097t0r1.wetalk

import android.os.Bundle
import me.s097t0r1.core.mvvm.base.BaseContainerActivity
import me.s097t0r1.core.navigation.message.StartFlowMessage
import me.s097t0r1.feature.splash.impl.di.SplashComponentHolder

class MainActivity : BaseContainerActivity() {

    override val containerId: Int = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun openLaunchScreen() {
        router.navigate(
            StartFlowMessage(
                SplashComponentHolder.get().starter.start()
            )
        )
    }
}
