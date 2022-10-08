package me.s097t0r1.ktcast.core.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.s097t0r1.core.mvi.base.BaseDialogFragment
import me.s097t0r1.core.ui_components.components.KtCastCircularProgressBar
import me.s097t0r1.core.ui_components.theme.KtCastTheme

class ProgressDialogFragment : BaseDialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
        }
    }

    @Preview
    @Composable
    override fun Content() {
        Surface(
            modifier = Modifier.size(200.dp),
            shape = RoundedCornerShape(48.dp),
            color = KtCastTheme.colors.backgroundPrimaryColor,
            contentColor = KtCastTheme.colors.textPrimaryColor
        ) {
            Box { KtCastCircularProgressBar(modifier = Modifier.align(Alignment.Center)) }
        }
    }
}
