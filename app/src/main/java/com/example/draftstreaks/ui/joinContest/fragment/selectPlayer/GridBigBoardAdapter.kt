package com.example.draftstreaks.ui.joinContest.fragment.selectPlayer

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.draftstreaks.R
import com.example.draftstreaks.clickInterface.OnItemClickListener
import com.example.draftstreaks.localModel.TeamModel


class GridBigBoardAdapter(private val courseList: List<TeamModel>, private val context: Context) : BaseAdapter()
{
    private var layoutInflater: LayoutInflater? = null
    private lateinit var courseTV: TextView
    private lateinit var courseIV: ImageView
    private lateinit var lay: ConstraintLayout
    private lateinit var card: CardView
    var selectedListener : OnItemClickListener? = null

    /*fun setClickListener(selectedListener:OnItemClickListener) {
        this.selectedListener = selectedListener
    }*/
    override fun getCount(): Int {
        return courseList.size
    }


    override fun getItem(position: Int): Any? {
        return null
    }


    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("CutPasteId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView

        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.layout_grid_big_board, null)
        }
        courseIV = convertView!!.findViewById(R.id.imageTeamClub)
        courseTV = convertView!!.findViewById(R.id.textSelectPlayerNumber)
        lay = convertView!!.findViewById(R.id.lay)
        card = convertView!!.findViewById(R.id.cardM)


        if (courseList.get(position).isSelect==true){
          /*  card.background(android.graphics.Color.parseColor("#00C5FF"))*/
            lay.background= ContextCompat.getDrawable(context,R.drawable.backround_g)
            card.alpha = 0.5f
            courseList.get(position).clubImage?.let { courseIV.setImageResource(it) }
            courseTV.setText(courseList.get(position).textNumber)
        }else{
            courseList.get(position).clubImage?.let { courseIV.setImageResource(it) }
            courseTV.setText(courseList.get(position).textNumber)
        }


  /*      val cardLay  = convertView!!.findViewById<ConstraintLayout>(R.id.cardLayout)
        cardLay.setOnClickListener{
            selectedListener!!.onClick(convertView,position)
        }
*/


            return convertView
    }
}


data class GridViewModal(
    val courseName: String,
    val courseImg:Int?
)