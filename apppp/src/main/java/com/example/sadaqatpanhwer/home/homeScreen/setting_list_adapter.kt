package com.example.android.screen6

import android.app.Activity
import android.app.Notification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.sadaqatpanhwer.home.R
import com.example.sadaqatpanhwer.home.homeScreen.first_listgetting

import java.util.ArrayList

class setting_list_adapter(context: Activity, notifications: ArrayList<first_listgetting>) : ArrayAdapter<first_listgetting>(context, 0, notifications) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Check if the existing view is being reused, otherwise inflate the view
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.home_item_list, parent, false)
        }

        val currentNotification = getItem(position)


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        val iconView = listItemView!!.findViewById<View>(R.id.list_item_icon) as ImageView

        iconView.setImageResource(currentNotification.imageResourceIdOne)

        return listItemView
    }



}
