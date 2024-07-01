package com.example.draftstreaks.ui.joinContest.fragment.selectPlayer

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.clickInterface.OnPlayerViewListener
import com.example.draftstreaks.databinding.ListRecyclerSelectPlayerBinding
import com.example.draftstreaks.localModel.ContestModel
import com.example.draftstreaks.ui.joinContest.activity.playerAboutActivity.PlayerInfoActivity
import com.example.draftstreaks.ui.joinContest.activity.selectPlayerActvitiy.SelectPlayerActivity

class SelectPlayerAdapter(var activity: SelectPlayerActivity) :
    RecyclerView.Adapter<SelectPlayerAdapter.ViewHolder>() {

    var getContestModel = emptyList<ContestModel>()
    var onClickListener: OnPlayerViewListener? = null

    fun setClickListener(onClickListener: OnPlayerViewListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ListRecyclerSelectPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)

    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val playerData = getContestModel[position]
        if (!playerData.isSelect) {
            holder.binding.imagePlayerSelect.setImageResource(playerData.playerImage)
            holder.binding.flagNationalSelect.setImageResource(playerData.flag)
            holder.binding.playerNameSelect.text = playerData.playerName
            holder.binding.textNationality.text = playerData.countryName
            holder.binding.textHeightValueSelect.text = playerData.height
            holder.binding.textWeightValueSelect.text = playerData.weight
            holder.binding.textPositionValueSelect.text = playerData.position
            holder.binding.textAgeinYearsValueSelect.text = playerData.age.toString()

            holder.binding.root.setOnClickListener { v ->
                onClickListener!!.onImageSelectClick(position, true,playerData.playerName)
            }

            holder.binding.imagePlayerSelect.setOnClickListener {
                activity.startActivity(Intent(activity, PlayerInfoActivity::class.java))
            }
        }



    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredPlayerList: List<ContestModel>) {
        this.getContestModel = filteredPlayerList
       notifyDataSetChanged()
    }

    override fun getItemCount() = getContestModel.size
    inner class ViewHolder(var binding: ListRecyclerSelectPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)
}