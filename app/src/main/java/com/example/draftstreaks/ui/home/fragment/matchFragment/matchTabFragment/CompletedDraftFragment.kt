package com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentCompletedDraftBinding
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.adapter.CompletedAdapter

class CompletedDraftFragment : Fragment() {
  lateinit var binding:FragmentCompletedDraftBinding
  lateinit var mActivity:HomeActivity
  lateinit var completedAdapter:CompletedAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_completed_draft, container, false)
        mActivity = activity as HomeActivity

        loadCompletedDraft()
        return binding.root
    }

    private fun loadCompletedDraft() {

        val getLeague = getLeagueModel()

        completedAdapter = CompletedAdapter(mActivity,getLeague)
        binding.completedRecycler.adapter = completedAdapter
        binding.completedRecycler.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false)
        binding.completedRecycler.setHasFixedSize(true)

    }


}