package com.example.draftstreaks.ui.home.fragment.MockDraftFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentMockDraftBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.activtiy.mockDraftActivity.MockDratfActivity
import com.example.draftstreaks.ui.home.fragment.MockDraftFragment.adapter.MockDraftListAdapter
import com.example.draftstreaks.ui.home.fragment.MockDraftFragment.adapter.MockDraftTabAdapter
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar
import com.google.android.material.tabs.TabLayout

class MockDraftFragment : Fragment() {
 lateinit var binding:FragmentMockDraftBinding
 lateinit var mActvity:MockDratfActivity
 lateinit var mockDraftTabAdapter:MockDraftTabAdapter
 lateinit var mockDraftAdapter:MockDraftListAdapter
    var leagueModel = ArrayList<LeagueModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_mock_draft, container, false)
        mActvity = activity as MockDratfActivity
        mActvity.setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "NFL Mock Draft 2024", R.drawable.back_arrow) { mActvity.finish() }

        loadMockDraftPage()

        return binding.root
    }

    private fun loadMockDraftTab() {

        binding.draftTabTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        mockDraftTabAdapter = MockDraftTabAdapter(childFragmentManager)
        binding.draftMokeViewPager.adapter = mockDraftTabAdapter
        binding.draftTabTabLayout.setupWithViewPager(binding.draftMokeViewPager)
        binding.draftTabTabLayout.getTabAt(0)

    }

    private fun loadMockDraftPage(){
        leagueModel = getLeagueModel()
        mockDraftAdapter =MockDraftListAdapter(mActvity,leagueModel)
        binding.mokeDraftRecycler.adapter = mockDraftAdapter
        binding.mokeDraftRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.mokeDraftRecycler.setHasFixedSize(true)
        loadMockDraftTab()
    }




}