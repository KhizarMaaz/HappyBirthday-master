package com.example.sadaqatpanhwer.home.homeScreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView
import com.example.android.screen6.setting_list_adapter

import com.example.sadaqatpanhwer.home.R
import kotlinx.android.synthetic.main.activity_finger_print.*
import kotlinx.android.synthetic.main.activity_home_screen.*
import java.util.ArrayList

class HomeScreen : AppCompatActivity() {
private lateinit var txt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_home_screen)




        val details = ArrayList<first_listgetting>()
        details.add(first_listgetting(R.drawable.drama))
        details.add(first_listgetting(R.drawable.drama))
        details.add(first_listgetting(R.drawable.drama))
        details.add(first_listgetting(R.drawable.drama))
        details.add(first_listgetting(R.drawable.drama))





        val settingsAdapter = setting_list_adapter(this, details)
        val listView = findViewById<View>(R.id.home_items) as ListView
        listView.adapter = settingsAdapter

        val inflater = layoutInflater
        val header = inflater.inflate(R.layout.header, home_items, false) as ViewGroup
        home_items.addHeaderView(header, null, false)
    }
}
