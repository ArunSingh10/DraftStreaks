package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ListSubmycontestBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity


class SubMyContestAdapter(var activity: FragmentActivity) :
    RecyclerView.Adapter<SubMyContestAdapter.ViewHolder>() {

     lateinit var leagueModel: ArrayList<LeagueModel>
    lateinit var adapter: SubChildMyContestAdapter
    lateinit var binding: ListSubmycontestBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListSubmycontestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        leagueModel = getLeagueModel()

        adapter = SubChildMyContestAdapter(activity, leagueModel)

        binding.subMyContestRecycler.adapter = adapter
        binding.subMyContestRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.subMyContestRecycler.setHasFixedSize(true)

        holder.binding.editIcon.setOnClickListener {
            activity.startActivity(Intent(activity, PrizePoolActivity::class.java))
            ScreenConstant.ScreenType = ScreenConstant.team
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(val binding: ListSubmycontestBinding) :
        RecyclerView.ViewHolder(binding.root)
}