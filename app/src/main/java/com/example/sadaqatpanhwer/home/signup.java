package com.example.sadaqatpanhwer.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sadaqatpanhwer.home.FingerAndCode.withoudFingr;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
        private EditText txtEmailAdress;
        private EditText txtPassword;
        private FirebaseAuth firebaseAuth;
        private Button regButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtEmailAdress = (EditText) findViewById(R.id.regEmail);
        txtPassword = (EditText) findViewById(R.id.regPass);
        regButton = (Button)findViewById(R.id.register);
        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = ProgressDialog.show(signup.this,"pleease wait...","processing..",true);
                (firebaseAuth.createUserWithEmailAndPassword(txtEmailAdress.getText().toString(),txtPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(signup.this,"Registration successful",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(signup.this,withoudFingr.class);
                            startActivity(i);
                        }else{
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(signup.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
