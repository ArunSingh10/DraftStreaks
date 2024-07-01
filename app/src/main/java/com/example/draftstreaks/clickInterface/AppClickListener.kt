package com.example.draftstreaks.clickInterface

import android.content.Intent
import android.view.View

interface SelectGameClickListener {
    fun onItemClick(position: Int)
    fun onGameItemClick(position: Int)
}

interface OnMatchClickListener {
    fun onMatchClick( matchId : String, startAt : String)
}

interface NetworkChangeListener {
    fun onVPNConnected()
    fun onNetworkConnected()
    fun onNetworkDisconnected()
}

interface SmsBroadcastReceiverListener {
    fun onSuccess(intent: Intent?)
    fun onFailure()
}

interface OnClickListener {
    fun onClick( position: Int, name : String)
}

interface OnItemClickListener {
    fun onClick(view : View, position: Int)
}

/*interface OnTransactionItemClickListener {
    fun onTransactionClick( dataItem: TransactionDataItem)
}

interface OnLeagueItemClickListener {
    fun onLeagueItemClick(dataItemLeague: DataItemLeague)
}*/

interface OnPlayerViewListener {

    fun onImageSelectClick(position: Int, isSelect: Boolean, playerName: String)

}

interface PlayerClickListener {
    fun onTeamSelectClick( position: Int)
  //  fun onPlayerDeselectClick(view: View, position: Int)
}
