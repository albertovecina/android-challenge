package com.idealista.android.challenge.list.ui.ads

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.R
import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.string
import com.idealista.android.challenge.list.domain.AdDetail

data class AdDetailModel(
    val id: String,
    val price: String,
    val title: String,
    val pictures: List<String>,
    val comment: String
)

fun AdDetail.toModel() =
    AdDetailModel(
        id = id,
        price = formatPrice(price),
        title = formatTitle(
            typology,
            operation
        ),
        pictures = pictures,
        comment = comment
    )

private fun formatPrice(price: Double) = "$price €"
private fun formatTitle(typology: Typology, operation: Operation) =
    CoreAssembler.stringsProvider.string(
        R.string.typology_at_operation,
        typology.string(),
        operation.string().toLowerCase()
    )