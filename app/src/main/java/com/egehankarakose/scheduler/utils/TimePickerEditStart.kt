package com.egehankarakose.scheduler.utils

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TextView
import android.app.DialogFragment
import android.app.Dialog
import android.content.DialogInterface
import java.util.Calendar
import android.widget.TimePicker
import android.widget.Toast
import com.egehankarakose.scheduler.R

class TimePickerEditStart : DialogFragment(), TimePickerDialog.OnTimeSetListener{

    private lateinit var calendar: Calendar

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Initialize a Calendar instance
        calendar = Calendar.getInstance()

        // Get the system current hour and minute
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        /*
            *** reference source developer.android.com ***

            TimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener listener,
            int hourOfDay, int minute, boolean is24HourView)
                Creates a new time picker dialog.

            TimePickerDialog(Context context, int themeResId, TimePickerDialog.OnTimeSetListener
            listener, int hourOfDay, int minute, boolean is24HourView)
                Creates a new time picker dialog with the specified theme.

        */

        // Create a TimePickerDialog with system current time
        // Return the TimePickerDialog
        return TimePickerDialog(
            activity, // Context
            android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth, // Theme
            this, // TimePickerDialog.OnTimeSetListener
            hour, // Hour of day
            minute, // Minute
            false // Is 24 hour view
        )
    }


    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Do something with the returned time
        val tv: TextView = activity.findViewById(com.egehankarakose.scheduler.R.id.EditEventStartEditText) as TextView
        tv.text = "${getHourAMPM(hourOfDay)}:$minute ${getAMPM(hourOfDay)}"

    }


    // When user cancel the time picker dialog
    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity,"Picker Canceled.", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }


    // Custom method to get AM PM value from provided hour
    private fun getAMPM(hour:Int):String{
        return if(hour>11)"PM" else "AM"
    }


    // Custom method to get hour for AM PM time format
    private fun getHourAMPM(hour:Int):Int{
        // Return the hour value for AM PM time format
        var modifiedHour = if (hour>11)hour-12 else hour
        if (modifiedHour == 0){modifiedHour = 12}
        return modifiedHour
    }
}
