package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ListRecyclerStreakBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.getLeagueModel


class StreaksAdapter (var activity: FragmentActivity, var matchData:ArrayList<LeagueModel>):
    RecyclerView.Adapter<StreaksAdapter.ViewHolder>() {
    lateinit var leagueModel:  ArrayList<LeagueModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListRecyclerStreakBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchData[position]

        holder.binding.textPointValue.text = match.pricePool
        holder.binding.textTypeofPointValue.text = match.title
        if (position % 2 == 0) {
            holder.binding.root.setBackgroundColor(
                ContextCompat.getColor( holder.itemView.context,  R.color.colorDarkSlateGray))
        } else {
            holder.binding.root.setBackgroundColor(
                ContextCompat.getColor( holder.itemView.context,  R.color.colorDeepSlateGray))
        }


    }

    override fun getItemCount(): Int {
        return matchData.size
    }
    inner class ViewHolder(val binding: ListRecyclerStreakBinding): RecyclerView.ViewHolder(binding.root)
}