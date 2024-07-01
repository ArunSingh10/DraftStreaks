package com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.FragmentBasketBallBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.SliderModel
import com.example.draftstreaks.localModel.getBannerModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter.BannerAdapter
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter.LeagueAdapter
import kotlinx.coroutines.launch

class BasketBallFragment : Fragment() {

    lateinit var binding: FragmentBasketBallBinding
    lateinit var mActivity: HomeActivity
    lateinit var leagueadapter: LeagueAdapter
    lateinit var bannerAdapter: BannerAdapter
    var bannerModel = ArrayList<SliderModel>()
    var leagueModel = ArrayList<LeagueModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basket_ball, container, false)
        mActivity = activity as HomeActivity
        loadScreen()
        loadLeague()
        return binding.root
    }

    fun loadScreen() {
            binding.bannerPager.setOnClickListener(mActivity)
            bannerModel = getBannerModel()
            bannerAdapter = BannerAdapter(mActivity)
            bannerAdapter.sliderModel = bannerModel
            binding.bannerPager.adapter = bannerAdapter
            binding.bannerPager.currentItem = 0
    }
    fun loadLeague(){
        val tabScreen= ScreenConstant.isBasketBall
            leagueModel = getLeagueModel()
            leagueadapter = LeagueAdapter(mActivity,leagueModel,tabScreen)
            binding.recycleContestBasketball.adapter = leagueadapter
            binding.recycleContestBasketball.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.recycleContestBasketball.setHasFixedSize(true)
    }

}