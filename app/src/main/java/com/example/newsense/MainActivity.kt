package com.example.newsense

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // Create a list of type SliderItems
    val sliderItems = mutableListOf<SliderItems>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val verticalViewPager = findViewById<VerticalViewPager>(R.id.verticalViewPager)

        sliderItems.add(SliderItems(R.drawable.ic_launcher_background))
        sliderItems.add(SliderItems(R.drawable.ic_launcher_background))
        sliderItems.add(SliderItems(R.drawable.ic_launcher_background))

        verticalViewPager.adapter = ViewPageAdapter(this, sliderItems)
    }
}