package com.egehankarakose.scheduler

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_event.*
import java.lang.Exception


class AddEventActivity : AppCompatActivity() {





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


    }
    fun saveEvent(view: View){

        if(AddEventDayEditText.text.toString().compareTo("Monday",true)==0 ){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()
            var obligation = "Free To Do"
            if(obligationCheckbox.isChecked){
                var obligation = "Have To!!!"
            }
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
        if(AddEventDayEditText.text.toString().compareTo("Tuesday",true) == 0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()
            var obligation = "Free To Do"
            if(obligationCheckbox.isChecked){
                var obligation = "Have To!!!"
            }
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
        if(AddEventDayEditText.text.toString().compareTo("Wednesday",true)==0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()
            var obligation = "Free To Do"
            if(obligationCheckbox.isChecked){
                var obligation = "Have To!!!"
            }
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
        if(AddEventDayEditText.text.toString().compareTo("thursday",true) == 0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()
            var obligation = "Free To Do"
            if(obligationCheckbox.isChecked){
                var obligation = "Have To!!!"
            }
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
        if(AddEventDayEditText.text.toString().compareTo("friday",true) == 0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()
            var obligation = "Free To Do"
            if(obligationCheckbox.isChecked){
                var obligation = "Have To!!!"
            }
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
        if(AddEventDayEditText.text.toString().compareTo("Saturday",true)==0){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()
            var obligation = "Free To Do"
            if(obligationCheckbox.isChecked){
                var obligation = "Have To!!!"
            }
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
        if(AddEventDayEditText.text.toString().compareTo("sunday",true) == 0 ){
            var title = AddEventTitleEditText.text.toString()
            var place = AddEventPlaceEditText.text.toString()
            var description = AddEventDescriptionEditText.text.toString()
            var obligation = "Free To Do"
            if(obligationCheckbox.isChecked){
                var obligation = "Have To!!!"
            }
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



}
