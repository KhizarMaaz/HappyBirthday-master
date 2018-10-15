package com.example.sadaqatpanhwer.home;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;

public class pictures extends AppCompatActivity {

    SliderLayout sliderLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pictures);

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 9; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.one);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.two);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.three);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.four);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.five);
                    break;
                case 5:
                    sliderView.setImageDrawable(R.drawable.six);
                    break;
                case 6:
                    sliderView.setImageDrawable(R.drawable.seven);
                    break;
                case 7:
                    sliderView.setImageDrawable(R.drawable.eight);
                    break;
                case 8:
                    sliderView.setImageDrawable(R.drawable.nine);
                    break;
                case 9:
                     sliderView.setImageDrawable(R.drawable.ten);
                     break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {

                @Override
                public void onSliderClick(SliderView sliderView) throws IOException {
                   // Toast.makeText(pictures.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                    OutputStream output;
                    // Find the SD Card path
                    File filepath = Environment.getExternalStorageDirectory();

                    // Create a new folder in SD Card
                    File dir = new File(filepath.getAbsolutePath()
                            + "/BirthdayApp/");
                    dir.mkdirs();
                    // Retrieve the image from the res folder
                    Drawable drawableee;
                    if(finalI==1){
                        drawableee = getResources().getDrawable(R.drawable.one);
                    }else if(finalI==2){
                        drawableee = getResources().getDrawable(R.drawable.two);
                    }else if(finalI==3){
                        drawableee = getResources().getDrawable(R.drawable.three);
                    }else if(finalI==4){
                        drawableee = getResources().getDrawable(R.drawable.four);
                    }else if(finalI==5){
                        drawableee = getResources().getDrawable(R.drawable.five);
                    }else if(finalI==6){
                        drawableee = getResources().getDrawable(R.drawable.six);
                    }else if(finalI==7){
                        drawableee = getResources().getDrawable(R.drawable.seven);
                    }else if(finalI==8){
                        drawableee = getResources().getDrawable(R.drawable.eight);
                    }else if(finalI==9){
                        drawableee = getResources().getDrawable(R.drawable.nine);
                    }else {
                        drawableee = getResources().getDrawable(R.drawable.ten);
                    }


                    BitmapDrawable drawable = (BitmapDrawable) drawableee;
                    Bitmap bitmap1 = drawable.getBitmap();

                    // Create a name for the saved image
                    File file;
                    if(finalI==1){
                        file = new File(dir, "card1.jpg" );
                    }else if(finalI==2){
                        file = new File(dir, "card2.jpg" );
                    }else if(finalI==3){
                        file = new File(dir, "card3.jpg" );
                    }else if(finalI==4){
                        file = new File(dir, "card4.jpg" );
                    }else if(finalI==5){
                        file = new File(dir, "card5.jpg" );
                    }else if(finalI==6){
                        file = new File(dir, "card6.jpg" );
                    }else if(finalI==7){
                        file = new File(dir, "card7.jpg" );
                    }else if(finalI==8){
                        file = new File(dir, "card8.jpg" );
                    }else if(finalI==9){
                        file = new File(dir, "card9.jpg" );
                    }else{
                        file = new File(dir, "card10.jpg" );
                    }

                    try {

                        output = new FileOutputStream(file);

                        // Compress into png format image from 0% - 100%
                        bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, output);
                        output.flush();
                        output.close();
                        Toast.makeText(pictures.this, "Image saved", Toast.LENGTH_SHORT).show();
                    }

                    catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }

    }
}

