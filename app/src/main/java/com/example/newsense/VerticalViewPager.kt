package com.example.newsense

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.Nullable
import androidx.viewpager.widget.ViewPager


class VerticalViewPager : ViewPager {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        setPageTransformer(true, VerticalTransformer())
        overScrollMode = View.OVER_SCROLL_NEVER
    }

    private class VerticalTransformer : ViewPager.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            if (position < -1) {
                page.alpha = 0f
            } else if (position <= 0) {
                page.alpha = 1f
                page.translationX = page.width * (-position)
                page.translationY = page.height * position
                page.scaleX = 1f
                page.scaleY = 1f
            } else if (position <= 1) {

                page.translationX = page.width * (-position)
                val scaleFactor = 0.75f + (1 - 0.75f) * (1 - Math.abs(position))
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            } else {
                page.alpha = 0f
            }

        }

    }

    private fun swapXYCordinates(event: MotionEvent): MotionEvent? {
        val width = width.toFloat()
        val height = height.toFloat()
        val newX = event.y / height * width
        val newY = event.x / width * height
        event.setLocation(newX, newY)
        return event
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val intercepted: Boolean = super.onInterceptTouchEvent(swapXYCordinates(ev!!)!!)
        swapXYCordinates(ev)
        return intercepted
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(swapXYCordinates(ev!!)!!)
    }

}