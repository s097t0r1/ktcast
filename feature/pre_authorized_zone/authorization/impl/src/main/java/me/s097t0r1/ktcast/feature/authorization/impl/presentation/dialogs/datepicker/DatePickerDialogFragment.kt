package me.s097t0r1.ktcast.feature.authorization.impl.presentation.dialogs.datepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import me.s097t0r1.ktcast.feature.authorization.impl.R
import java.time.LocalDate
import java.time.ZoneId

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val now = LocalDate.now()
        return DatePickerDialog(
            requireContext(),
            this,
            now.year, now.monthValue, now.dayOfMonth
        )
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        setFragmentResult(
            R.id.authorization_feature_date_picker_dialog.toString(),
            bundleOf(
                KEY_SELECTED_DATE to LocalDate.of(year, month, dayOfMonth)
                    .atStartOfDay(ZoneId.systemDefault())
                    .toInstant()
                    .toEpochMilli()
            )
        )
    }

    companion object {
        const val KEY_SELECTED_DATE = "SELECTED_DATE"
    }
}