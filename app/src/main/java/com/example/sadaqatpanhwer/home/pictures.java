package com.example.sadaqatpanhwer.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.io.File;

public class pictures extends AppCompatActivity {
    SliderLayout sliderLayout;
    private String id;
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

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.image3);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.image2);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.image5);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.image6);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(pictures.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
//                    final Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                    shareIntent.setType("*/*");
//                    final File photoFile = new File(getFilesDir(), "image3.jpg");
//                    shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
//                    startActivity(Intent.createChooser(shareIntent, "Share image using"));
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }

    }

}
