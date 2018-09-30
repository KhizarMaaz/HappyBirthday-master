package com.example.sadaqatpanhwer.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView

import com.smarteist.autoimageslider.SliderLayout
import com.smarteist.autoimageslider.SliderView

class pictures : AppCompatActivity() {
    internal lateinit var sliderLayout: SliderLayout
    private val id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_pictures)
        sliderLayout = findViewById(R.id.imageSlider)
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL) //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.scrollTimeInSec = 1 //set scroll delay in seconds :
        setSliderViews()
    }

    private fun setSliderViews() {

        for (i in 0..9) {

            val sliderView = SliderView(this)

            when (i) {
                0 -> sliderView.setImageDrawable(R.drawable.one)
                1 -> sliderView.setImageDrawable(R.drawable.two)
                2 -> sliderView.setImageDrawable(R.drawable.three)
                3 -> sliderView.setImageDrawable(R.drawable.five)
                4 -> sliderView.setImageDrawable(R.drawable.six)
                5 -> sliderView.setImageDrawable(R.drawable.seven)
                6 -> sliderView.setImageDrawable(R.drawable.four)
                7 -> sliderView.setImageDrawable(R.drawable.eight)
                8 -> sliderView.setImageDrawable(R.drawable.nine)
                9 -> sliderView.setImageDrawable(R.drawable.ten)
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP)
            val finalI = i

            sliderView.setOnSliderClickListener {
                //    Toast.makeText(pictures.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "*/*"
                shareIntent.setPackage("com.instagram.android")
                shareIntent.putExtra(Intent.EXTRA_STREAM, "" + R.drawable.drama)
                startActivity(shareIntent)
                shareIntent
            }

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView)
        }

    }

}
