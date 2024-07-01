package com.example.draftstreaks.localModel

import com.example.draftstreaks.R

data class SliderModel(val icon:Int, val title: String, val description:String)
data class LeagueModel(val icon:Int, val title: String, val pricePool:String)

fun getSliderModel(): ArrayList<SliderModel> {
    val sliderModel = ArrayList<SliderModel>()

    sliderModel.clear()
    sliderModel.add(SliderModel( R.drawable.image_phone1,"Predict the Future","Contrary to popular belief, Lorem Ipsum is not simply random Contrary to popular belief, Lorem Ipsum is not simply text. Contrary to popular belie" ))
    sliderModel.add(SliderModel( R.drawable.image_phone2,"Predict the Future", "Contrary to popular belief, Lorem Ipsum is not simply random Contrary to popular belief, Lorem Ipsum is not simply text. Contrary to popular belie"))
    sliderModel.add(SliderModel( R.drawable.image_phone3,"Predict the Future","Contrary to popular belief, Lorem Ipsum is not simply random Contrary to popular belief, Lorem Ipsum is not simply text. Contrary to popular belie"))

    return sliderModel
}
fun getSliderModelFootBall(): ArrayList<SliderModel> {

    val sliderModel = ArrayList<SliderModel>()

    sliderModel.clear()
    sliderModel.add(SliderModel( R.drawable.banner_football,"Predict the Future","Contrary to popular belief, Lorem Ipsum is not simply random Contrary to popular belief, Lorem Ipsum is not simply text. Contrary to popular belie" ))
    sliderModel.add(SliderModel( R.drawable.banner_football,"Predict the Future", "Contrary to popular belief, Lorem Ipsum is not simply random Contrary to popular belief, Lorem Ipsum is not simply text. Contrary to popular belie"))
    sliderModel.add(SliderModel( R.drawable.banner_football,"Predict the Future","Contrary to popular belief, Lorem Ipsum is not simply random Contrary to popular belief, Lorem Ipsum is not simply text. Contrary to popular belie"))

    return sliderModel
}

fun getBannerModel(): ArrayList<SliderModel> {
    val bannerModel = ArrayList<SliderModel>()

    bannerModel.clear()
    bannerModel.add(SliderModel( R.drawable.image_home_banner,"","" ))
    bannerModel.add(SliderModel( R.drawable.image_home_banner,"", ""))
    bannerModel.add(SliderModel( R.drawable.image_home_banner,"",""))

    return bannerModel
}
fun getLeagueModel(): ArrayList<LeagueModel> {
    val leagueModel = ArrayList<LeagueModel>()

    leagueModel.clear()
    leagueModel.add(LeagueModel( R.drawable.image_player1,"NBA Mock Draft 2024" ,"Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player2,"NBA Mock Draft 2024", "Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player1,"NBA Mock Draft 2024","Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player2,"NBA Mock Draft 2024","Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player1,"NBA Mock Draft 2024","Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player2,"NBA Mock Draft 2024","Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player1,"NBA Mock Draft 2024","Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player2,"NBA Mock Draft 2024","Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player1,"NBA Mock Draft 2024","Prize Pool $ 2M"))
    leagueModel.add(LeagueModel( R.drawable.image_player2,"NBA Mock Draft 2024","Prize Pool $ 2M"))

    return leagueModel
}