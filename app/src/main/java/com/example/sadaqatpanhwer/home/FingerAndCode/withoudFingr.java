package com.example.sadaqatpanhwer.home.FingerAndCode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sadaqatpanhwer.home.R;
import com.example.sadaqatpanhwer.home.home;

public class withoudFingr extends AppCompatActivity {
    private EditText name;
    private EditText pass;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_withoud_fingr);
        name = (EditText) findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), pass.getText().toString());
            }
        });
    }
        private void validate(String userName, String userPassword){
            if((userName.equalsIgnoreCase("Admin")) && (userPassword.equalsIgnoreCase("aaaaa"))){
                Intent inten = new Intent(withoudFingr.this,home.class);
               finish();
                startActivity(inten);
                name.setText("");
                pass.setText("");
            }else {
                pass.setText("");
                Toast.makeText(getApplicationContext(), "wrong userName/password",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

