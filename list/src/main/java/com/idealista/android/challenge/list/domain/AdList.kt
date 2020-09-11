package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.entity.ListEntity
import kotlin.collections.List

data class AdList(
    val ads: List<Ad>)

fun ListEntity.toDomain() = AdList(elementList.map { it.toDomain() })