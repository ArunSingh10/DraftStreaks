package com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentUpcomingDraftBinding
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.adapter.UpcomingAdapter

class UpcomingDraftFragment : Fragment() {
    lateinit var binding: FragmentUpcomingDraftBinding
    lateinit var mActivity: HomeActivity
    lateinit var upcomingAdapter: UpcomingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_upcoming_draft, container, false)
        mActivity = activity as HomeActivity
        loadUpcomingPage()
        return binding.root
    }

    private fun loadUpcomingPage() {
        val getLeague = getLeagueModel()
        upcomingAdapter = UpcomingAdapter(mActivity, getLeague)
        binding.upcomingRecycler.adapter = upcomingAdapter
        binding.upcomingRecycler.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        binding.upcomingRecycler.setHasFixedSize(true)
    }

}