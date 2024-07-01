package com.example.draftstreaks.localModel

import com.example.draftstreaks.R

data class SupportModel(var imagepluse:Int,var textquestion:String,var textanswer:String)

fun getSupportModel(): ArrayList<SupportModel> {
    val supportModel = ArrayList<SupportModel>()

    supportModel.clear()
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 01 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 02 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 03 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 04 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 05 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 06 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 07 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 08 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 09 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 10 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 11 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 12 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 13 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 14 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
    supportModel.add(SupportModel(R.drawable.image_plus_circle,"Question number 15 goes in here?","Lorem ipsum dolor sit amet, consectetur adipiscing elit."))

    return supportModel
}