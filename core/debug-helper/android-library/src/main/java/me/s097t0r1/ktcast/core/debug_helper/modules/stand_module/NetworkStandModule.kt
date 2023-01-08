package me.s097t0r1.ktcast.core.debug_helper.modules.stand_module

import android.widget.Toast
import com.pandulapeter.beagle.Beagle
import com.pandulapeter.beagle.common.configuration.Text
import com.pandulapeter.beagle.common.contracts.BeagleListItemContract
import com.pandulapeter.beagle.modules.SingleSelectionListModule
import me.s097t0r1.ktcast.core.debug_helper.KtCastDebugHelper

internal fun NetworkStandModule() = SingleSelectionListModule<StandButtonModuleItem>(
    title = "Select STAND",
    items = Stand.values().map(::StandButtonModuleItem),
    initiallySelectedItemId = KtCastDebugHelper.storage.stand.name,
    onSelectionChanged = {
        if (it == null) return@SingleSelectionListModule
        KtCastDebugHelper.storage.stand = it.stand
        Beagle.performOnHide {
            Toast.makeText(
                Beagle.currentActivity,
                "Please completely restart app",
                Toast.LENGTH_LONG
            ).show()
        }.also { Beagle.hide() }
    }
)

data class StandButtonModuleItem(val stand: Stand) : BeagleListItemContract {

    override val id: String = stand.name

    override val title: Text = Text.CharSequence(stand.name)
}
