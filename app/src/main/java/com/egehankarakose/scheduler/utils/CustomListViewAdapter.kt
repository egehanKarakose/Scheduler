package com.egehankarakose.scheduler.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.egehankarakose.scheduler.Event
import android.app.Activity
import android.widget.Button
import kotlinx.android.synthetic.main.custom_list_view_layout.view.*

class CustomListViewAdapter(private var activity:Activity, private var items: ArrayList<Event>) :  BaseAdapter(){
        private class ViewHolder(row: View?) {
            var title: TextView? = null
            var place: TextView? = null
            var description: TextView? = null
            var obligation: TextView? = null
            var startTime: TextView? = null
            var endTime: TextView? = null



            init {
                this.title = row?.findViewById(com.egehankarakose.scheduler.R.id.subjectTitleText)
                this.place = row?.findViewById(com.egehankarakose.scheduler.R.id.subjectPlaceText)
                this.description = row?.findViewById(com.egehankarakose.scheduler.R.id.subjectDescriptionText)
                this.obligation = row?.findViewById(com.egehankarakose.scheduler.R.id.subjectObligationText)
                this.startTime = row?.findViewById(com.egehankarakose.scheduler.R.id.StartTime)
                this.endTime = row?.findViewById(com.egehankarakose.scheduler.R.id.EndTime)


            }
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View
            val viewHolder: ViewHolder
            if (convertView == null) {
                val inflater: LayoutInflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(com.egehankarakose.scheduler.R.layout.custom_list_view_layout, null)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as ViewHolder
            }
            var emp = items[position]
            viewHolder.title?.text = emp.title
            viewHolder.description?.text = emp.description
            viewHolder.place?.text = emp.place
            viewHolder.obligation?.text = emp.obligation
            viewHolder.startTime?.text = emp.startTime
            viewHolder.endTime?.text = emp.endTime





            return view
        }
        override fun getItem(i: Int): Event {
            return items[i]
        }
        override fun getItemId(i: Int): Long {
            return i.toLong()
        }
        override fun getCount(): Int {
            return items.size
        }
}
