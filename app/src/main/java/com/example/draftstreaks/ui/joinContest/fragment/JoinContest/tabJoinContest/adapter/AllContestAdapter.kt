package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.clickInterface.OnItemClickListener
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ListallcontestBinding
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity

class AllContestAdapter (var activity: JoinContestActivity, /*private var allcontest: List<>*/):
    RecyclerView.Adapter<AllContestAdapter.ViewHolder>(){

    var onClickListener: OnItemClickListener? = null

    fun setClickListener(onClickListener: OnItemClickListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding  = ListallcontestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentprogress:Int


        holder.binding.root.setOnClickListener{v->
            ScreenConstant.ScreenType = ScreenConstant.prizePool
        activity.startActivity(Intent(activity, PrizePoolActivity::class.java))
        }
        holder.binding.buttonJoinFee.setOnClickListener{
            ScreenConstant.ScreenType = ScreenConstant.team
            activity.startActivity(Intent(activity, PrizePoolActivity::class.java))
        }
    }

    override fun getItemCount() = 5
    inner class ViewHolder(var binding:ListallcontestBinding): RecyclerView.ViewHolder(binding.root)
}