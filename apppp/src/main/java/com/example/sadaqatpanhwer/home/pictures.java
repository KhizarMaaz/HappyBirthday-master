package com.example.sadaqatpanhwer.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

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
                    sliderView.setImageDrawable(R.drawable.five);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.six);
                    break;
                case 5:
                    sliderView.setImageDrawable(R.drawable.seven);
                    break;
                case 6:
                    sliderView.setImageDrawable(R.drawable.four);
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
            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public Intent onSliderClick(SliderView sliderView) {
                    //    Toast.makeText(pictures.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("*/*");
                    shareIntent.setPackage("com.instagram.android");
                    shareIntent.putExtra(Intent.EXTRA_STREAM,""+R.drawable.drama);
                    startActivity(shareIntent);
                    return shareIntent;
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }

    }

}
