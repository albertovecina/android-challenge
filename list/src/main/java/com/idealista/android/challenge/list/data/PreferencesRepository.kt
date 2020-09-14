package com.idealista.android.challenge.list.data

class PreferencesRepository(private val dataSource: PreferencesDataSource) {

    fun setFavouriteAd(adId: String, isFavourite: Boolean) =
        dataSource.setFavouriteAd(adId, isFavourite)

    fun isFavouriteAd(adId: String): Boolean = dataSource.isFavouriteAd(adId)

}