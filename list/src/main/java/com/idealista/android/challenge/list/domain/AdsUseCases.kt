package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.data.AdsRepository

fun adDetail(repository: AdsRepository, url: String): () -> Either<CommonError, AdDetail> = {
    repository.adDetail(url)
}