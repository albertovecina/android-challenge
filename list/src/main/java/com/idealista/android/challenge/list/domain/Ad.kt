package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdEntity

data class Ad(
    val id: String,
    val thumbnail: String,
    val price: Double,
    val typology: Typology,
    val operation: Operation,
    val detailUrl: String
)

fun AdEntity.toDomain() =
    Ad(
        propertyCode ?: "",
        multimedia?.images?.get(0)?.url ?: "",
        price ?: 0.0,
        Typology.from(propertyType ?: ""),
        Operation.from(operation ?: ""),
        detailUrl ?: ""
    )
