package com.example.sadaqatpanhwer.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;


import com.blanyal.remindme.MainActivity;
import com.example.sadaqatpanhwer.home.quotesActivities.quotes;


public class home extends AppCompatActivity {



    GridView gridView;
    String letterList[]={"BD Reminder","Pictures","Wish","Photo Edit"};
    int lettersIcon[]={R.drawable.wish,R.drawable.camera,R.drawable.quotation,R.drawable.picediting};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);


        gridView = (GridView)findViewById(R.id.gridview);
        GridAdapter adapter = new GridAdapter(home.this,lettersIcon,letterList);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id ) {

                switch (position) {
                    case 0:
                        Intent myIntent = new Intent(home.this, MainActivity.class);
                       home.this.startActivity(myIntent);
                        break;
                    case 1:
                        Intent myIntent1 = new Intent(home.this, pictures.class);
                        home.this.startActivity(myIntent1);

                      break;

                    case 2:
                        Intent myIntent2 = new Intent(home.this, quotes.class);
                        home.this.startActivity(myIntent2);

                        break;

                    case 3:
                        Intent myIntent3 = new Intent(home.this, photoEditing.class);
                        home.this.startActivity(myIntent3);
                        break;


                }
            }

        });

    }

}
