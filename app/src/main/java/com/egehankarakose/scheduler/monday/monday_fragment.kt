package com.egehankarakose.scheduler.monday

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.baoyz.swipemenulistview.SwipeMenuListView
import com.egehankarakose.scheduler.EditEventActivity
import com.egehankarakose.scheduler.Event
import com.egehankarakose.scheduler.utils.CustomListViewAdapter
import android.graphics.drawable.ColorDrawable
import com.baoyz.swipemenulistview.SwipeMenuItem
import com.baoyz.swipemenulistview.SwipeMenuCreator
import android.graphics.Color
import android.widget.Adapter
import android.widget.ListView
import com.baoyz.swipemenulistview.SwipeMenu
import java.util.*
import kotlin.collections.ArrayList


class monday_fragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater?.inflate(com.egehankarakose.scheduler.R.layout.monday, container, false)
        var eventList: ArrayList<Event> = ArrayList()
        eventList = addEvent()





        val listView = view.findViewById<ListView>(com.egehankarakose.scheduler.R.id.mondayListView)
        listView.adapter = CustomListViewAdapter(this.requireActivity(), eventList)


        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this.requireContext(),EditEventActivity::class.java)
            intent.putExtra("title",eventList[position].title)
            intent.putExtra("description",eventList[position].description)
            intent.putExtra("place",eventList[position].place)
            intent.putExtra("day","monday")
            startActivity(intent)


        }



        return view
    }

    fun addEvent(): ArrayList<Event> {

        var eventList: ArrayList<Event> = ArrayList()


        try {
            val eventDataBase = activity!!.openOrCreateDatabase("Event", Context.MODE_PRIVATE, null)
            eventDataBase.execSQL("CREATE TABLE IF NOT EXISTS  mondayEvent (title VARCHAR,place VARCHAR,description VARCHAR,obligation VARCHAR ,startTime VARCHAR, endTime VARCHAR)")
            val cursor = eventDataBase.rawQuery("SELECT * FROM mondayEvent", null)
            val titleIndex = cursor.getColumnIndex("title")
            val placeIndex = cursor.getColumnIndex("place")
            val descriptionIndex = cursor.getColumnIndex("description")
            val obligationIndex = cursor.getColumnIndex("obligation")
            val startTimeIndex = cursor.getColumnIndex("startTime")
            val endTimeIndex = cursor.getColumnIndex("endTime")

            cursor.moveToFirst()
            while (cursor != null) {
                var emp = Event()
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

        }catch (e:Exception){
            e.printStackTrace()
        }



        return eventList

    }







}