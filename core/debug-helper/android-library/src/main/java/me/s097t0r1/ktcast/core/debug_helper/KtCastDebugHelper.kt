package me.s097t0r1.ktcast.core.debug_helper

import android.app.Application
import com.pandulapeter.beagle.Beagle
import com.pandulapeter.beagle.common.configuration.Behavior
import com.pandulapeter.beagle.log.BeagleLogger
import com.pandulapeter.beagle.logOkHttp.BeagleOkHttpLogger
import com.pandulapeter.beagle.modules.*
import timber.log.Timber

object KtCastDebugHelper {

    fun initialize(application: Application) {
        Beagle.initialize(
            application = application,
            behavior = Behavior(
                networkLogBehavior = Behavior.NetworkLogBehavior(
                    networkLoggers = listOf(BeagleOkHttpLogger),
                ),
                logBehavior = Behavior.LogBehavior(
                    loggers = listOf(BeagleLogger)
                ),
            )
        )
        initModules()
    }

    private fun initModules() {
        Beagle.set(
            HeaderModule(
                title = "KtCast",
                text = BuildConfig.BUILD_TYPE
            ),
            AppInfoButtonModule(),
            DeveloperOptionsButtonModule(),
            PaddingModule(),
            TextModule("General", TextModule.Type.SECTION_HEADER),
            KeylineOverlaySwitchModule(),
            AnimationDurationSwitchModule(),
            ScreenCaptureToolboxModule(),
            DividerModule(),
            TextModule("Logs", TextModule.Type.SECTION_HEADER),
            NetworkLogListModule(), // Might require additional setup, see below
            LogListModule(), // Might require additional setup, see below
            LifecycleLogListModule(),
            DividerModule(),
            TextModule("Other", TextModule.Type.SECTION_HEADER),
            DeviceInfoModule(),
            BugReportButtonModule()
        )
    }

    object Logger {

        fun init() {
            Timber.plant(Timber.DebugTree())
            Timber.plant(
                object : Timber.Tree() {
                    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                        Beagle.log("[$tag] $message", "Timber", t?.stackTraceToString())
                    }
                }
            )
        }

        fun v(message: String) = Timber.v(message)
        fun v(t: Throwable, message: String) = Timber.v(t, message)
        fun v(t: Throwable) = Timber.v(t)

        fun d(message: String) = Timber.d(message)
        fun d(t: Throwable, message: String) = Timber.d(t, message)
        fun d(t: Throwable) = Timber.d(t)

        fun i(message: String) = Timber.i(message)
        fun i(t: Throwable, message: String) = Timber.i(t, message)
        fun i(t: Throwable) = Timber.i(t)

        fun w(message: String) = Timber.w(message)
        fun w(t: Throwable, message: String) = Timber.w(t, message)
        fun w(t: Throwable) = Timber.w(t)

        fun e(message: String) = Timber.e(message)
        fun e(t: Throwable, message: String) = Timber.e(t, message)
        fun e(t: Throwable) = Timber.e(t)

        fun wtf(message: String) = Timber.wtf(message)
        fun wtf(t: Throwable, message: String) = Timber.wtf(t, message)
        fun wtf(t: Throwable) = Timber.wtf(t)

    }

}