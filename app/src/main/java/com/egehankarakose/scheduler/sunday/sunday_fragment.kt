package com.egehankarakose.scheduler.monday

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.egehankarakose.scheduler.R
import com.egehankarakose.scheduler.Event
import com.egehankarakose.scheduler.utils.CustomListViewAdapter

class sunday_fragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater?.inflate(R.layout.sunday, container, false)

        var empList: ArrayList<Event>
        empList = addEvent()

        val listView = view.findViewById<ListView>(R.id.sundayListView)
        listView.adapter = CustomListViewAdapter(this.requireActivity(), empList)

        return view
    }

    fun addEvent(): ArrayList<Event> {

        var eventList: ArrayList<Event> = ArrayList()
        var emp = Event()

        try {
            val eventDataBase = activity!!.openOrCreateDatabase("Event", Context.MODE_PRIVATE, null)
            eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  sundayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
            val cursor = eventDataBase.rawQuery("SELECT * FROM sundayEvent", null)
            val titleIndex = cursor.getColumnIndex("title")
            val placeIndex = cursor.getColumnIndex("place")
            val descriptionIndex = cursor.getColumnIndex("description")
            val obligationIndex = cursor.getColumnIndex("obligation")
            val startTimeIndex = cursor.getColumnIndex("startTime")
            val endTimeIndex = cursor.getColumnIndex("endTime")

            cursor.moveToFirst()
            while (cursor != null) {
                emp.title = cursor.getString(titleIndex)
                emp.place = cursor.getString(placeIndex)
                emp.description = cursor.getString(descriptionIndex)
                emp.obligation = cursor.getString(obligationIndex)
                emp.startTime = cursor.getString(startTimeIndex)
                emp.endTime = cursor.getString(endTimeIndex)
                eventList.add(emp)

                cursor.moveToNext()

            }
            cursor?.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }



        return eventList

    }


}