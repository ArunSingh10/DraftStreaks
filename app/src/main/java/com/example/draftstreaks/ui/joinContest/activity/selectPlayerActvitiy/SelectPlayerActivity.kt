package com.example.draftstreaks.ui.joinContest.activity.selectPlayerActvitiy


import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.clickInterface.OnPlayerViewListener
import com.example.draftstreaks.constant.Constant
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ActivitySelectPlayerBinding
import com.example.draftstreaks.databinding.PopupLayoutBinding
import com.example.draftstreaks.localModel.ContestModel
import com.example.draftstreaks.localModel.getSelectPlayer
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.joinContest.fragment.selectPlayer.SelectPlayerAdapter
import com.example.draftstreaks.utility.AlertDialogView
import com.example.draftstreaks.utility.Utils
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar
import java.util.Locale


class SelectPlayerActivity : AppCompatActivity(), OnPlayerViewListener, View.OnClickListener {

    private lateinit var short: List<ContestModel>
    lateinit var binding: ActivitySelectPlayerBinding
    lateinit var selectPlayerAdapter: SelectPlayerAdapter
    var contestModels = ArrayList<ContestModel>()
    var playerName = ""
    var positionTeam: Int? = null
    var isSelect = false
    var isPlayerSelected = false
    var rowIndex = -1
    var replacePlayer = false
    private lateinit var dialog: ProgressDialog

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this@SelectPlayerActivity,
            R.layout.activity_select_player
        )

        setupToolbar(
            binding.includeToolbar.toolbar,
            binding.includeToolbar.textViewToolbarTitle,
            "Select Player",
            R.drawable.back_arrow
        ) {
            onBackPressed()
        }

        dialog = Utils.showLoadingDialog(this)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({
            checkAppPermission()
        }, 1000)

    }

    fun checkAppPermission() {
        if (!NetworkUtils.isInternetAvailable(this)) {
            Utils.showNetworkLostAlertDialog(this@SelectPlayerActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {

            loadScreen()
        }
    }

    fun loadScreen() {
        dialog.dismiss()
        binding.buttonContinueSelect.setOnClickListener(this)
        binding.cardGuide.setOnClickListener {
            if (rowIndex == -1) {
                binding.dropdownImage.setImageResource(R.drawable.upword_arrow_sky)
                rowIndex = 0
                showPopupMenu(it)
            } else {
                binding.dropdownImage.setImageResource(R.drawable.image_dropdown)
                binding.recyclerPlayerSelect.visibility = View.GONE
                rowIndex = -1

            }

        }
        binding.cardCancelRed.setOnClickListener(this)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun showPopupMenu(anchorView: View) {

        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_layout, null)

        val popupWindow = PopupWindow(
            popupView,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            true
        )
        val popupTextView = popupView.findViewById<TextView>(R.id.highProjected)
        popupTextView.text = "Heighest Projected Pick"

        popupTextView.setOnClickListener {
            if (rowIndex == 0) {
                popupWindow.dismiss()
                binding.recyclerPlayerSelect.visibility = View.VISIBLE
                loadList()

                rowIndex = 0
            } else {
                rowIndex = 0
            }
        }

        popupWindow.showAsDropDown(anchorView, -145, 0)


    }

    private fun loadList() {
        contestModels = getSelectPlayer()
        short = contestModels.sortedByDescending { t -> t.weight }
        selectPlayerAdapter = SelectPlayerAdapter(this)
        positionTeam = intent.extras!!.getInt("positionTeam")
        isSelect = intent.extras!!.getBoolean("isSelect")
        playerName = intent.extras!!.getString("playerName", "")

        binding.recyclerPlayerSelect.adapter = selectPlayerAdapter
        selectPlayerAdapter.getContestModel = short
        binding.recyclerPlayerSelect.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerPlayerSelect.setHasFixedSize(true)
        selectPlayerAdapter.setClickListener(this)

        if (playerName.isNotEmpty()) {
            var position = -1
            for (i in 0 until contestModels.size) {
                if (contestModels[i].playerName == playerName) {
                    position = i
                    break
                }
            }
            if (position != -1) updatePlayerView(position, playerName)
        }

        searchPlayer()

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {

            R.id.cardCancelRed->{
                if(replacePlayer==true){
                    replacePlayer()
                }
            }
            R.id.buttonContinueSelect -> {
                if (isPlayerSelected==true){
                    val intent = Intent()
                    intent.putExtra("positionTeam", positionTeam)
                    intent.putExtra("playerName", playerName)
                    setResult(RESULT_OK, intent)
                    finish()
                }else{
                    Utils.showErrorMessage(this,"Please Select Player")
                }
            }
        }
    }

    private fun searchPlayer() {

        binding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filter(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }

    fun filter(text: String) {
        val filteredPlayerAry: ArrayList<ContestModel> = ArrayList()
        filteredPlayerAry.clear()
        val courseAry: List<ContestModel> = short

        for (eachPlayer in courseAry.indices) {
            if (courseAry[eachPlayer].playerName.toLowerCase(Locale.ROOT)
                    .contains(text.toLowerCase(Locale.ROOT)) || courseAry[eachPlayer].playerName.toUpperCase(
                    Locale.ROOT
                ).contains(text.toUpperCase(Locale.ROOT))
            ) {
                filteredPlayerAry.add(courseAry.get(eachPlayer))


            }
        }
        selectPlayerAdapter.filterList(filteredPlayerAry)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onImageSelectClick(position: Int, isSelect: Boolean, playerName: String) {
        for (i in 0 until contestModels.size) {
            selectPlayerAdapter.getContestModel[position].isSelect = false

        }
        if(isPlayerSelected==true){
            Utils.showErrorMessage(this,"You Can Select Only One Player at a Time")
        }

        updatePlayerView(position, playerName)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatePlayerView(position: Int, playerName1: String) {

                this.playerName = playerName1
                binding.cardPlayerInfo.visibility = View.VISIBLE
                binding.clonePlayerName.text = playerName
                binding.textPositionValue.text = selectPlayerAdapter.getContestModel[position].position
                binding.textHeightValue.text = selectPlayerAdapter.getContestModel[position].height
                binding.textWeightValue.text = selectPlayerAdapter.getContestModel[position].weight
                binding.textNationality.text = selectPlayerAdapter.getContestModel[position].countryName
                binding.textAgeinYearsValue.text = selectPlayerAdapter.getContestModel[position].age.toString()
                replacePlayer = true
                isPlayerSelected = true
                binding.imagePlayer.setImageResource(selectPlayerAdapter.getContestModel[position].playerImage)
                selectPlayerAdapter.notifyDataSetChanged()

        }




    @SuppressLint("NotifyDataSetChanged")
    fun replacePlayer() {
        AlertDialogView.showSimpleDialog(this, "You Want to Remove Player") {
            binding.cardPlayerInfo.visibility = View.GONE
            for (i in 0 until contestModels.size) {
                contestModels[i].isSelect = false
                replacePlayer = false
            }

            isPlayerSelected = false
            playerName = ""
            selectPlayerAdapter.getContestModel = short
            selectPlayerAdapter.notifyDataSetChanged()

        }
    }

    override fun onRestart() {
        super.onRestart()
        checkAppPermission()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent()
        intent.putExtra("data", "back")
        setResult(RESULT_OK, intent)
        finish()
    }
}
