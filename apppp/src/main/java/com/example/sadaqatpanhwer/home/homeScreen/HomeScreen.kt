package com.example.sadaqatpanhwer.home.homeScreen

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.*
import com.blanyal.remindme.MainActivity
import com.example.android.screen6.setting_list_adapter
import com.example.sadaqatpanhwer.home.*
import com.example.sadaqatpanhwer.home.Editing.EditImageActivity
import com.example.sadaqatpanhwer.home.Editing.PhotoApp

import com.example.sadaqatpanhwer.home.R.drawable.user
import com.example.sadaqatpanhwer.home.quotesActivities.quotes
import com.facebook.AccessToken
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.readystatesoftware.systembartint.SystemBarTintManager
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_sign_in_or_sign_up.*
import kotlinx.android.synthetic.main.home_item_list.*

import java.util.ArrayList
import com.google.firebase.auth.FirebaseUser



class HomeScreen : AppCompatActivity() {
private lateinit var logout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_home_screen)

        

        val details = ArrayList<first_listgetting>()
        details.add(first_listgetting(R.drawable.bdreminders))
        details.add(first_listgetting(R.drawable.bdpix))
        details.add(first_listgetting(R.drawable.bdwishes))
        details.add(first_listgetting(R.drawable.bdediting))

        val settingsAdapter = setting_list_adapter(this, details)
        val listView = findViewById<View>(R.id.home_items) as ListView
        listView.adapter = settingsAdapter

        val inflater = layoutInflater
        val header = inflater.inflate(R.layout.header, home_items, false) as ViewGroup
        home_items.addHeaderView(header, null, false)

        listView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            when (position) {
                1 -> {
                   // Toast.makeText(this, "new activity!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                2 -> {
                   // Toast.makeText(this, "new activity!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, pictures::class.java)
                    startActivity(intent)
                }
                3 -> {
                   // Toast.makeText(this, "new activity!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, quotes::class.java)
                    startActivity(intent)
                }
                4 -> {
                    //Toast.makeText(this, "new activity!", Toast.LENGTH_SHORT).show()
                   val intent = Intent(this, EditImageActivity::class.java)
                    startActivity(intent)
                }
            }
        })

        logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this@signIn, "Its toast!", Toast.LENGTH_SHORT).show()
            val user = FirebaseAuth.getInstance().currentUser
            val facebookAccessToken = AccessToken.getCurrentAccessToken()

            if(user!=null || facebookAccessToken != null){
                LoginManager.getInstance().logOut()
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, signInOrSignUp::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "please first login!", Toast.LENGTH_SHORT).show()
            }

        })//end of start button
    }
}
