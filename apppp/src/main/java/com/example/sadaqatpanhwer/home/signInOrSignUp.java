package com.example.sadaqatpanhwer.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.sadaqatpanhwer.home.FingerAndCode.signIn;

public class signInOrSignUp extends AppCompatActivity {

    private Button signInButton;
    private Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in_or_sign_up);

        signInButton = (Button)findViewById(R.id.signIn);
        signUpButton=(Button)findViewById(R.id.signUpp);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signInOrSignUp.this, signIn.class);
                startActivity(i);
            }
        });//end of sign in
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signInOrSignUp.this,signup.class);
                startActivity(i);
            }
        });//end of signupButton
    }
}
