package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import kotlin.collections.List

data class AdDetail(
    val id: String,
    val pictures: List<String>,
    val price: Double,
    val typology: Typology,
    val operation: Operation
)

fun AdDetailEntity.toDomain(): AdDetail = AdDetail(
    id = this.adid ?: "",
    pictures = this.multimedia?.images?.map { it.url } ?: emptyList(),
    price = this.price ?: 0.0,
    typology = Typology.from(this.extendedPropertyType ?: ""),
    operation = Operation.from(this.operation ?: "")
)