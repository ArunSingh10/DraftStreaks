package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.constant.ScreenConstant

import com.example.draftstreaks.databinding.ListMyDraftBinding
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity

class MyDraftAdapter(
    var activity: JoinContestActivity,
) : RecyclerView.Adapter<MyDraftAdapter.ViewHolder>(){

    lateinit var subDraftAdapter: SubMyDraftAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDraftAdapter.ViewHolder {

        val createdView = ListMyDraftBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(createdView)

    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyDraftAdapter.ViewHolder, position: Int) {
        var leagueModel = getLeagueModel()
        subDraftAdapter = SubMyDraftAdapter(activity,leagueModel)
        holder.binding.subRecyclerMyDraft.adapter = subDraftAdapter
        holder.binding.subRecyclerMyDraft.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.subRecyclerMyDraft.setHasFixedSize(true)
        //      teamContestAdapter.setclickOnListner(this)
holder.binding.imageEditIconMyDraft.setOnClickListener{
    ScreenConstant.isEdit = "Yes"
    ScreenConstant.ScreenType =ScreenConstant.team
    activity.startActivity(Intent(activity,PrizePoolActivity::class.java))
}

    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(var binding: ListMyDraftBinding) :
        RecyclerView.ViewHolder(binding.root)


}