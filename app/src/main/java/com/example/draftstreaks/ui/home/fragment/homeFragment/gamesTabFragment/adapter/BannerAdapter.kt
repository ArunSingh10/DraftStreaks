package com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.localModel.SliderModel

class BannerAdapter  (var activity: FragmentActivity) : PagerAdapter() {

    var sliderModel: List<SliderModel> = emptyList()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater: LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.item_banner, container, false) as ViewGroup

        val imagebanner = view.findViewById<ImageView>(R.id.imageBanner)
      /*  if (tabScreen == ScreenConstant.isFootball){

        }else{
            holder.binding.imageDraft.setImageResource(R.drawable.image_draft_nba)
        }*/
        imagebanner.setImageResource(sliderModel[position].icon)
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