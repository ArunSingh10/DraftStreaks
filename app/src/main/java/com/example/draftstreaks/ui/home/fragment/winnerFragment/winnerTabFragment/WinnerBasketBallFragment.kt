package com.example.draftstreaks.ui.home.fragment.winnerFragment.winnerTabFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentWinnerBasketBallBinding
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.winnerFragment.adapter.WinnerBasketBallAdapter

class WinnerBasketBallFragment : Fragment() {
   lateinit var binding:FragmentWinnerBasketBallBinding
   lateinit var mActivity:HomeActivity
   lateinit var adapter:WinnerBasketBallAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_winner_basket_ball, container, false)
        mActivity = activity as HomeActivity
        loadPage()

        return binding.root
    }

    private fun loadPage() {
       adapter = WinnerBasketBallAdapter(mActivity)
        binding.winnerBasketRecycler.adapter = adapter
        binding.winnerBasketRecycler.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false)
        binding.winnerBasketRecycler.setHasFixedSize(true)
    }

}