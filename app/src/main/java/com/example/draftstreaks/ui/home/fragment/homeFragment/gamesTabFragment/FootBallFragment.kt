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
import com.example.draftstreaks.databinding.FragmentFootBallBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.SliderModel
import com.example.draftstreaks.localModel.getBannerModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.localModel.getSliderModelFootBall
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter.BannerAdapter
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter.LeagueAdapter
import kotlinx.coroutines.launch

class FootBallFragment : Fragment() {

    lateinit var binding: FragmentFootBallBinding
    lateinit var mActivity: HomeActivity
    lateinit var leagueadapter: LeagueAdapter
    lateinit var bannerAdapter: BannerAdapter
    var bannerModel = ArrayList<SliderModel>()
    var leagueModel = ArrayList<LeagueModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_foot_ball, container, false)
        mActivity = activity as HomeActivity
        loadScreen()
        loadLeague()
        return binding.root
    }


    fun loadScreen() {

            binding.bannerFootballPager.setOnClickListener(mActivity,)
            bannerModel = getSliderModelFootBall()
            bannerAdapter = BannerAdapter(mActivity)
            bannerAdapter.sliderModel = bannerModel
            binding.bannerFootballPager.adapter = bannerAdapter
            binding.bannerFootballPager.currentItem = 0
    }
    private fun loadLeague(){
        val tabScreen= ScreenConstant.isFootball
            leagueModel = getLeagueModel()
            leagueadapter = LeagueAdapter(mActivity,leagueModel,tabScreen)
            binding.recycleContestFootball.adapter = leagueadapter
            binding.recycleContestFootball.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.recycleContestFootball.setHasFixedSize(true)
    }
}