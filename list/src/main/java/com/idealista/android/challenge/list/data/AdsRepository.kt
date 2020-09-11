package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.domain.AdDetail
import com.idealista.android.challenge.list.domain.toDomain

class AdsRepository(private val dataSource: AdsDataSource) {

    fun adDetail(url: String): Either<CommonError, AdDetail> =
        dataSource.adDetail(url).map { it.toDomain() }

}