package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.data.ListRepository
import com.idealista.android.challenge.list.data.PreferencesRepository

fun list(repository: ListRepository): () -> Either<CommonError, AdList> = {
    repository.list()
}

fun isFavouriteAd(repository: PreferencesRepository, adId: String): Boolean =
    repository.isFavouriteAd(adId)

fun setFavouriteAd(repository: PreferencesRepository, adId: String, isFavourite: Boolean) =
    repository.setFavouriteAd(adId, isFavourite)