package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.PreferencesProvider

class PreferencesDataSource(private val preferencesProvider: PreferencesProvider) {

    fun setFavouriteAd(adId: String, isFavourite: Boolean) =
        preferencesProvider.putBoolean(adId, isFavourite)

    fun isFavouriteAd(adId: String): Boolean = preferencesProvider.getBoolean(adId, false)

}