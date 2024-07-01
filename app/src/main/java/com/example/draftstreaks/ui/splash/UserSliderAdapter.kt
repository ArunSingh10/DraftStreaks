package com.example.draftstreaks.ui.splash

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.draftstreaks.R
import com.example.draftstreaks.localModel.SliderModel

class UserSliderAdapter (var activity: FragmentActivity, ) : PagerAdapter() {

    var sliderModel: List<SliderModel> = emptyList()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater: LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.item_slider, container, false) as ViewGroup
        val sliderImage: ImageView = view.findViewById(R.id.imagePhone)
        val sliderParentTxt: TextView = view.findViewById(R.id.layoutPredict)
        val sliderChildTxt: TextView = view.findViewById(R.id.descriptionPredict)
        sliderImage.setImageResource(sliderModel[position].icon)
        sliderParentTxt.text = sliderModel[position].title
        sliderChildTxt.text = sliderModel[position].description
        container.addView(view,0)
        return view

    }

    override fun getCount(): Int {
        return sliderModel.size
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}