package com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentLiveDraftBinding
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.adapter.LiveAdapter

class LiveDraftFragment : Fragment() {
    lateinit var binding:FragmentLiveDraftBinding
    lateinit var mActivity:HomeActivity
    lateinit var adapter:LiveAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_live_draft, container, false)
        mActivity = activity as HomeActivity
        loadPage()
        return binding.root
    }

    private fun loadPage() {
        val getLeague = getLeagueModel()
        adapter = LiveAdapter(mActivity,getLeague)
        binding.liveMatchRecycler.adapter = adapter
        binding.liveMatchRecycler.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false)
        binding.liveMatchRecycler.setHasFixedSize(true)
    }

}