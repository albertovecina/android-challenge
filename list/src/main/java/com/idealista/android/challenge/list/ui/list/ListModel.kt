package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.list.domain.AdList

data class ListModel(
    val ads: MutableList<AdModel>
)

fun AdList.toModel(favouriteAdsMapper: (String) -> Boolean) =
    ListModel(ads.map { it.toModel(favouriteAdsMapper(it.id)) }.toMutableList())