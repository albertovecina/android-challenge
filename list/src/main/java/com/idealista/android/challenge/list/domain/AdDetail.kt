package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdDetailEntity

data class AdDetail(
    val id: String,
    val price: Double,
    val typology: Typology,
    val operation: Operation,
    val comment: String,
    val pictures: List<String>
)

fun AdDetailEntity.toDomain(): AdDetail = AdDetail(
    id = this.adid ?: "",
    price = this.price ?: 0.0,
    typology = Typology.from(this.extendedPropertyType ?: ""),
    operation = Operation.from(this.operation ?: ""),
    pictures = multimedia?.images?.map { it.url } ?: emptyList(),
    comment = propertyComment ?: ""
)