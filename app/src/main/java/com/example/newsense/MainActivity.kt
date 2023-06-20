package com.example.newsense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // Create a list of type SliderItems
    private val sliderItems: MutableList<SliderItems> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val verticalViewPager = findViewById<VerticalViewPager>(R.id.verticalViewPager)

        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.tesla))
        sliderItems.add(SliderItems(R.drawable.ic_launcher_background))

        verticalViewPager.adapter = ViewPagerAdapter(this@MainActivity, sliderItems)
    }
}
