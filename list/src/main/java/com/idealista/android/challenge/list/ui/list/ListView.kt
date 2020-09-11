package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.list.ui.list.ListModel

interface ListView {
    fun render(list: ListModel)
    fun navigateToAd(url: String)
}