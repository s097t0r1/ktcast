package me.s097t0r1.ktcast

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import me.s097t0r1.core.mvi.base.BaseContainerActivity
import me.s097t0r1.core.navigation.message.StartFlowMessage
import me.s097t0r1.feature.splash.impl.di.SplashComponentHolder

class MainActivity : BaseContainerActivity(R.layout.activity_main) {

    override val containerId: Int = R.id.container

    override fun setupToolbar(): Toolbar {
        return findViewById<MaterialToolbar>(R.id.mtToolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        findViewById<MaterialToolbar>(R.id.mtToolbar).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun openLaunchScreen() {
        router.navigate(
            StartFlowMessage(
                SplashComponentHolder.get().starter.start()
            )
        )
    }
}
