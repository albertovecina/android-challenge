package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.list.domain.AdList

data class ListModel(
    val ads: List<AdModel>)

fun AdList.toModel() =
    ListModel(ads.map { it.toModel() })