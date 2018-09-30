package com.example.sadaqatpanhwer.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button

import com.example.sadaqatpanhwer.home.FingerAndCode.signIn

class signInOrSignUp : AppCompatActivity() {

    private var signInButton: Button? = null
    private var signUpButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_sign_in_or_sign_up)

        signInButton = findViewById<View>(R.id.signIn) as Button
        signUpButton = findViewById<View>(R.id.signUpp) as Button

        signInButton!!.setOnClickListener {
            val i = Intent(this@signInOrSignUp, signIn::class.java)
            startActivity(i)
        }//end of sign in
        signUpButton!!.setOnClickListener {
            val i = Intent(this@signInOrSignUp, signup::class.java)
            startActivity(i)
        }//end of signupButton
    }
}
