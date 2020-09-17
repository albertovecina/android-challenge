package com.idealista.android.challenge.list.ui.ads

interface AdsView {
    fun showProgress()
    fun hideProgress()
    fun render(model: AdDetailModel)
}