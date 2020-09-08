package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.data.ListRepository

fun list(repository: ListRepository): () -> Either<CommonError, List> = {
    repository.list()
}

fun adDetail(repository: ListRepository, url: String): () -> Either<CommonError, AdDetail> = {
    repository.adDetail(url)
}