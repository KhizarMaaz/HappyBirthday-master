package com.example.sadaqatpanhwer.home.FingerAndCode

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sadaqatpanhwer.home.R
import com.example.sadaqatpanhwer.home.R.id.password
import com.example.sadaqatpanhwer.home.home
import com.example.sadaqatpanhwer.home.signup
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import com.google.firebase.auth.FirebaseUser
class withoudFingr : AppCompatActivity() {
    private var callbackManager: CallbackManager? = null
    private var SignIn: Button?=null
    private var mAuth: FirebaseAuth? = null
    private lateinit var firstname: TextView
    private lateinit var email: TextView
    private lateinit var userEmail:EditText
    private lateinit var userPass:EditText
    private lateinit var profile: Profile
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_withoud_fingr)
                //firebase auth
                mAuth = FirebaseAuth.getInstance();

            userEmail = findViewById<EditText>(R.id.userName)
            userPass = findViewById<EditText>(R.id.password)

            //for fb
//            firstname = findViewById<TextView>(R.id.name)
//            email = findViewById<TextView>(R.id.email)
//

            /****************************************
             * Sign in with facebook
             ****************************************/
        var btnLoginFacebook = findViewById<Button>(R.id.login_button)
        btnLoginFacebook.setOnClickListener(View.OnClickListener {
            // Login
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email","fname"))
            LoginManager.getInstance().registerCallback(callbackManager,
                    object : FacebookCallback<LoginResult> {
                        override fun onSuccess(loginResult: LoginResult) {
                            Toast.makeText(this@withoudFingr, "Its toast!", Toast.LENGTH_SHORT).show()
//                        profile = Profile.getCurrentProfile()
//                            var id = profile.id
//                            var firs=profile.firstName
//

                        }//end of onsuccess


                        override fun onCancel() {
                            Log.d("MainActivity", "Facebook onCancel.")

                        }

                        override fun onError(error: FacebookException) {
                            Log.d("MainActivity", "Facebook onError.")

                        }
                    })

        })//end of facebook button

            /****************************************
             * skip all setup and procces to activity
             ****************************************/
                var startButton = findViewById<TextView>(R.id.startbtn)
                startButton.setOnClickListener(View.OnClickListener {
                    //Toast.makeText(this@withoudFingr, "Its toast!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, home::class.java)
                    startActivity(intent)
                })//end of start button

                /****************************************
                 * Sign up Button
                 ****************************************/
                  var signUpButoon = findViewById<TextView>(R.id.signUp)
                signUpButoon.setOnClickListener(View.OnClickListener {
                    val intent = Intent(this, signup::class.java)
                    startActivity(intent)
                })//end of signup button

                /****************************************
                 * login button for email and pass
                 ****************************************/

                var loginButton = findViewById<Button>(R.id.login)
                loginButton.setOnClickListener(View.OnClickListener {
                    // Toast.makeText(this@withoudFingr, "Its sign in", Toast.LENGTH_SHORT).show()
                    if(userEmail == null || userEmail.equals("null") || userEmail.length()<=0 && userPass.equals("null") || userPass==null || userPass.length()<=0){
                         Toast.makeText(this, "please enter username and password", Toast.LENGTH_SHORT).show()
                    }else {
                        val progressDialog = ProgressDialog.show(this, "pleease wait...", "processing..", true)
                        mAuth!!.signInWithEmailAndPassword(userEmail.getText().toString(), userPass.getText().toString()).addOnCompleteListener(OnCompleteListener<AuthResult> { task ->

                            progressDialog.dismiss()

                            if (task.isSuccessful) {
                                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                                val i = Intent(this, home::class.java)
                                //i.putExtra("Email", mAuth!!.currentUser!!.getEmail())
                                startActivity(i)
                                userEmail.setText("")
                                userPass.setText("")
                            } else {
                                Log.e("Error", task.exception!!.toString())
                                Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                    })//end of login button


            }//end of method

    protected override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result back to the Facebook SDK
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.getCurrentUser()

    }

}//end of class

