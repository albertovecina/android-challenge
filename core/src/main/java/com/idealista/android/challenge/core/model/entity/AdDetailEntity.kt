package com.idealista.android.challenge.core.model.entity

data class AdDetailEntity(
    val adid: String?,
    val price: Double?,
    val extendedPropertyType: String?,
    val operation: String?,
    val propertyComment: String?,
    val multimedia: MultimediasEntity?
)