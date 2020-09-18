package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.data.ListRepository

fun list(repository: ListRepository): () -> Either<CommonError, AdList> = {
    repository.list()
}

fun setAdAsFavourite(
    repository: ListRepository,
    adId: String
): Either<CommonError, Unit> {
    repository.setFavouriteAd(adId, true)
    return Either.Right(Unit)
}

fun removeAdAsFavourite(
    repository: ListRepository,
    adId: String
): Either<CommonError, Unit> {
    repository.setFavouriteAd(adId, false)
    return Either.Right(Unit)
}