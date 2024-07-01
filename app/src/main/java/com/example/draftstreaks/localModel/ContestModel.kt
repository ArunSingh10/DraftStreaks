package com.example.draftstreaks.localModel

import com.example.draftstreaks.R

data class ContestModel(
    var playerImage: Int,
    var playerName: String,
    var position: String,
    var height: String,
    var weight: String,
    var age: Int,
    var flag: Int,
    var countryName: String,
    var isSelect: Boolean
)


data class TeamModel(
    var textNumber: String,
    var clubImage: Int,
    var playerName: String,
    var isSelect: Boolean,
)

fun getSelectPlayer(): ArrayList<ContestModel> {
    val selectModel = ArrayList<ContestModel>()
    selectModel.clear()
    selectModel.add(
        ContestModel(
            R.drawable.image_player2,
            "Alexandre Sarr",
            "C",
            "7'1\"",
            "216 lbs",
            19,
            R.drawable.image_country_flag,
            "France",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "Reed Sheppard",
            "SG",
            "6'3\"",
            "184 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "r",
            "SG",
            "6'3\"",
            "182 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "t",
            "SG",
            "6'3\"",
            "197 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "y",
            "SG",
            "6'3\"",
            "180 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "u",
            "SG",
            "6'3\"",
            "167 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "w",
            "SG",
            "6'3\"",
            "197 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "q",
            "SG",
            "6'3\"",
            "185 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "z",
            "SG",
            "6'3\"",
            "181 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "a",
            "SG",
            "6'3\"",
            "187 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    selectModel.add(
        ContestModel(
            R.drawable.image_player1,
            "c",
            "SG",
            "6'3\"",
            "187 lbs",
            19,
            R.drawable.flag_london,
            "London, Kentucky",
            false
        )
    )
    return selectModel
}

fun getTeam(): ArrayList<TeamModel> {
    val teamModel = ArrayList<TeamModel>()
    teamModel.clear()
    teamModel.add(TeamModel("1", R.drawable.image_teamlogo1, "Select Player", false))
    teamModel.add(TeamModel("2", R.drawable.image_teamlogo2, "Select Player", false))
    teamModel.add(TeamModel("3", R.drawable.image_teamlogo3, "Select Player", false))
    return teamModel
}