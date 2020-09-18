package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.entity.ListEntity

data class AdList(
    val ads: List<Ad>
)

fun ListEntity.toDomain(favouriteAdsMapper: (String?) -> Boolean) =
    AdList(elementList.map { it.toDomain(favouriteAdsMapper(it.propertyCode)) })