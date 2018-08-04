package com.example.sadaqatpanhwer.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class fb extends AppCompatActivity {

    private TextView tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
    tvEmail = (TextView)findViewById(R.id.email);
//    tvEmail.setText(getIntent().getExtras().getString("Email"));
    }
}
