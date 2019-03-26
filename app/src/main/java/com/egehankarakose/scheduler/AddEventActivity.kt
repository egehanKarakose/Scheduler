package com.egehankarakose.scheduler

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import com.egehankarakose.scheduler.utils.TimePickerFragment
import com.egehankarakose.scheduler.utils.TimePickerFragmentEndTime
import kotlinx.android.synthetic.main.activity_add_event.*
import java.lang.Exception
import java.util.*


class AddEventActivity : AppCompatActivity() {



    var obligation = "Free To Do"

    lateinit var option :Spinner
    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

    try {
        val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
        eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  mondayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
        eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  tuesdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
        eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  wednesdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
        eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  thursdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
        eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  fridayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
        eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  saturdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
        eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  sundayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")


    }catch (e:Exception){
        e.printStackTrace()
    }

        obligationCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                obligation = "Have To!!!"
            }
        }

       option = findViewById(R.id.AddEventDaySpinner) as Spinner
        val options = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result = "Please Select A Day"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result = options.get(position)
            }
        }

    }
    fun saveEvent(view: View){

        if(result.compareTo("Monday",true)==0 ){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()

            var startTime = AddEventStartEditText.text.toString()
            var endTime = AddEventEndEditText.text.toString()

            try {
                val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
                eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  mondayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
                var sqlString = "INSERT INTO  mondayEvent (title,place,description,obligation,startTime,endTime) values (?,?,?,?,?,?)"
                val statement = eventDataBase.compileStatement(sqlString)

                statement.bindString(1,title)
                statement.bindString(2,place)
                statement.bindString(3,description)
                statement.bindString(4,obligation)
                statement.bindString(5,startTime)
                statement.bindString(6,endTime)
                statement.execute()

            }catch (e:Exception){
                e.printStackTrace()
            }




        }
        if(result.compareTo("Tuesday",true) == 0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()


            var startTime = AddEventStartEditText.text.toString()
            var endTime = AddEventEndEditText.text.toString()

            try{
                val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
                eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  tuesdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")

                var sqlString = "INSERT INTO  tuesdayEvent (title,place,description,obligation,startTime,endTime) values (?,?,?,?,?,?)"
                val statement = eventDataBase.compileStatement(sqlString)

                statement.bindString(1,title)
                statement.bindString(2,place)
                statement.bindString(3,description)
                statement.bindString(4,obligation)
                statement.bindString(5,startTime)
                statement.bindString(6,endTime)
                statement.execute()

            }catch (e :Exception){
                e.printStackTrace()
            }


        }
        if(result.compareTo("Wednesday",true)==0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()

            var startTime = AddEventStartEditText.text.toString()
            var endTime = AddEventEndEditText.text.toString()
            try{
                val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
                eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  wednesdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")

                var sqlString = "INSERT INTO  wednesdayEvent (title,place,description,obligation,startTime,endTime) values (?,?,?,?,?,?)"
                val statement = eventDataBase.compileStatement(sqlString)

                statement.bindString(1,title)
                statement.bindString(2,place)
                statement.bindString(3,description)
                statement.bindString(4,obligation)
                statement.bindString(5,startTime)
                statement.bindString(6,endTime)
                statement.execute()

            }catch (e :Exception){
                e.printStackTrace()
            }

        }
        if(result.compareTo("thursday",true) == 0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()

            var startTime = AddEventStartEditText.text.toString()
            var endTime = AddEventEndEditText.text.toString()
            try{
                val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
                eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  thursdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")

                var sqlString = "INSERT INTO  thursdayEvent (title,place,description,obligation,startTime,endTime) values (?,?,?,?,?,?)"
                val statement = eventDataBase.compileStatement(sqlString)

                statement.bindString(1,title)
                statement.bindString(2,place)
                statement.bindString(3,description)
                statement.bindString(4,obligation)
                statement.bindString(5,startTime)
                statement.bindString(6,endTime)
                statement.execute()

            }catch (e :Exception){
                e.printStackTrace()
            }
        }
        if(result.compareTo("friday",true) == 0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()


            var startTime = AddEventStartEditText.text.toString()
            var endTime = AddEventEndEditText.text.toString()
            try{
                val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
                eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  fridayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")

                var sqlString = "INSERT INTO  fridayEvent (title,place,description,obligation,startTime,endTime) values (?,?,?,?,?,?)"
                val statement = eventDataBase.compileStatement(sqlString)

                statement.bindString(1,title)
                statement.bindString(2,place)
                statement.bindString(3,description)
                statement.bindString(4,obligation)
                statement.bindString(5,startTime)
                statement.bindString(6,endTime)
                statement.execute()

            }catch (e :Exception){
                e.printStackTrace()
            }
        }
        if(result.compareTo("Saturday",true)==0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()

            var startTime = AddEventStartEditText.text.toString()
            var endTime = AddEventEndEditText.text.toString()
            try{
                val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
                eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  saturdayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")

                var sqlString = "INSERT INTO  saturdayEvent (title,place,description,obligation,startTime,endTime) values (?,?,?,?,?,?)"
                val statement = eventDataBase.compileStatement(sqlString)

                statement.bindString(1,title)
                statement.bindString(2,place)
                statement.bindString(3,description)
                statement.bindString(4,obligation)
                statement.bindString(5,startTime)
                statement.bindString(6,endTime)
                statement.execute()

            }catch (e :Exception){
                e.printStackTrace()
            }
        }
        if(result.compareTo("sunday",true) == 0 ){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()

            var startTime = AddEventStartEditText.text.toString()
            var endTime = AddEventEndEditText.text.toString()
            try{
                val eventDataBase = this.openOrCreateDatabase("Event",Context.MODE_PRIVATE,null)
                eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  sundayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")

                var sqlString = "INSERT INTO  sundayEvent (title,place,description,obligation,startTime,endTime) values (?,?,?,?,?,?)"
                val statement = eventDataBase.compileStatement(sqlString)

                statement.bindString(1,title)
                statement.bindString(2,place)
                statement.bindString(3,description)
                statement.bindString(4,obligation)
                statement.bindString(5,startTime)
                statement.bindString(6,endTime)
                statement.execute()

            }catch (e :Exception){
                e.printStackTrace()
            }
        }
        var intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)

    }

    fun setStartTime(view: View){

        val newFragment = TimePickerFragment()
        newFragment.show(fragmentManager, "Time Picker")

    }
    fun setEndTime(view: View){
        val newFragment = TimePickerFragmentEndTime()
        newFragment.show(fragmentManager, "Time Picker")



    }



}
