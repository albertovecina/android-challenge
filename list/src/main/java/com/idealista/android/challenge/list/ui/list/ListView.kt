package com.idealista.android.challenge.list.ui.list

interface ListView {
    fun showProgress()
    fun hideProgress()
    fun render(list: ListModel)
    fun removeAdAtPosition(position: Int)
    fun navigateToAd(url: String)
}