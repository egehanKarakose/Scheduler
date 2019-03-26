package com.egehankarakose.scheduler

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.egehankarakose.scheduler.utils.TimePickerEditEnd
import com.egehankarakose.scheduler.utils.TimePickerEditStart
import com.egehankarakose.scheduler.utils.TimePickerFragment
import com.egehankarakose.scheduler.utils.TimePickerFragmentEndTime
import kotlinx.android.synthetic.main.activity_edit_event.*
import java.lang.Exception

class EditEventActivity : AppCompatActivity() {

    var obligation = "Free To Do!!"
    var oldTitle = ""
    var oldDesc = ""
    var oldPlace = ""
    var eventName = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)



        obligationCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                obligation = "Have To!!!"
            }
        }


        val intent = intent
        oldTitle = intent.getStringExtra("title")
        oldDesc = intent.getStringExtra("description")
        oldPlace = intent.getStringExtra("place")
        val day = intent.getStringExtra("day")

        if(day.compareTo("monday",true) == 0){
            eventName = "mondayEvent"

        }
        if(day.compareTo("tuesday",true) == 0){
            eventName = "tuesdayEvent"

        }
        if(day.compareTo("wednesday",true) == 0){
            eventName = "wednesdayEvent"

        }
        if(day.compareTo("thursday",true) == 0){
            eventName = "thursdayEvent"

        }
        if(day.compareTo("friday",true) == 0){
            eventName = "fridayEvent"

        }
        if(day.compareTo("saturday",true) == 0){
            eventName = "saturdayEvent"

        }
        if(day.compareTo("sunday",true) == 0){
            eventName = "sundayEvent"

        }



        EditEventTitleEditText.append(oldTitle)
        EditEventPlaceEditText.append(oldPlace)
        EditEventDescriptionEditText.append(oldDesc)



    }
    fun saveEditEvent(view: View){
        var title = EditEventTitleEditText.text.toString()
        var  place = EditEventPlaceEditText.text.toString()
        var description = EditEventDescriptionEditText.text.toString()
        var  startTime = EditEventStartEditText.text.toString()
        var endTime = EditEventEndEditText.text.toString()


        try {


            val eventDataBase = this.openOrCreateDatabase("Event", Context.MODE_PRIVATE,null)
            eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  $eventName  (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
            //val sqlString = "UPDATE $eventName SET title = $title, place = $place, description = $description, obligation = $obligation, startTime = $startTime, endTime = $endTime WHERE title = $oldTitle ;")
            var values = ContentValues()
            values.put("title", title)
            values.put("description", description)
            values.put("place", place)
            values.put("obligation", obligation)
            values.put("endTime", endTime)
            values.put("startTime", startTime)
            eventDataBase.update(eventName, values, "title = ?", arrayOf(oldTitle))



        }catch (e: Exception){
            e.printStackTrace()
        }
        var intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)


    }
    fun setEditStartTime(view: View){
        val newFragment = TimePickerEditStart()
        newFragment.show(fragmentManager, "Time Picker")
    }
    fun setEditEndTime(view: View){
        val newFragment = TimePickerEditEnd()
        newFragment.show(fragmentManager, "Time Picker")
    }
}
