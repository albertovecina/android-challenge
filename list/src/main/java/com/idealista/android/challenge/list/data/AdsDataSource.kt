package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.api.ListApi
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.model.entity.ListEntity
import com.idealista.android.challenge.core.wrench.type.Either

class AdsDataSource(private val api: ListApi) {

    fun adDetail(url: String): Either<CommonError, AdDetailEntity> = api.adDetail(url)

}