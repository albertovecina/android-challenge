package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.domain.AdList
import com.idealista.android.challenge.list.domain.toDomain

class ListRepository(
    private val listDataSource: ListDataSource,
    private val preferencesDataSource: PreferencesDataSource
) {

    fun list(): Either<CommonError, AdList> = listDataSource.list()
        .map { it.toDomain { adId -> preferencesDataSource.isFavouriteAd(adId ?: "") } }

    fun setFavouriteAd(adId: String, isFavourite: Boolean) =
        preferencesDataSource.setFavouriteAd(adId, isFavourite)

}