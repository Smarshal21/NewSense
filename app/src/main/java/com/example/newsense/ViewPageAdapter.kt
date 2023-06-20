package com.example.newsense

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter


class ViewPageAdapter(context: Context, sliderItems: List<SliderItems>) : PagerAdapter() {
    var sliderItems: List<SliderItems>
    var mlayoutInflater: LayoutInflater
    var context: Context = context

    init {
        this.context = context
        this.sliderItems = sliderItems
        mlayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getCount(): Int {
        return sliderItems.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemview:View = mlayoutInflater.inflate(R.layout.item_container, container, false)
        val imageView = itemview.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(sliderItems[position].image)
        container.addView(imageView)
        return itemview
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}