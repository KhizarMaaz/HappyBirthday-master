package com.example.sadaqatpanhwer.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sadaqatpanhwer.home.FingerAndCode.signIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
        private EditText txtEmailAdress;
        private EditText txtPassword;
        private FirebaseAuth firebaseAuth;
        private Button regButton;
        private ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        txtEmailAdress = (EditText) findViewById(R.id.regEmail);
        txtPassword = (EditText) findViewById(R.id.regPass);
        regButton = (Button)findViewById(R.id.register);
        backButton = (ImageButton)findViewById(R.id.back);
        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtEmailAdress == null || txtEmailAdress.equals("null") || txtEmailAdress.length() <= 0 && txtPassword.equals("null") || txtPassword == null || txtPassword.length() <= 0) {
                    Toast.makeText(signup.this, "please enter email and password", Toast.LENGTH_SHORT).show();
                } else {


                    final ProgressDialog progressDialog = ProgressDialog.show(signup.this, "pleease wait...", "processing..", true);
                    (firebaseAuth.createUserWithEmailAndPassword(txtEmailAdress.getText().toString(), txtPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(signup.this, signIn.class);
                                startActivity(i);
                            } else {
                                Log.e("Error", task.getException().toString());
                                Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });//end of click on reg
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signup.this,signInOrSignUp.class);
                startActivity(i);
                finish();
            }
        });//end of backbuton
    }//end of oncreate
}//end of classs
