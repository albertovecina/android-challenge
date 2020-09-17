package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.domain.AdList
import com.idealista.android.challenge.list.domain.isFavouriteAd
import com.idealista.android.challenge.list.domain.list
import com.idealista.android.challenge.list.domain.setFavouriteAd

class ListPresenter(private val view: ListView) {

    private var adsList: ListModel = ListModel(arrayListOf())
    private var favouriteAdsList: ListModel = ListModel(arrayListOf())

    private var isShowingFavourites: Boolean = false

    fun onListNeeded() {
        view.showProgress()
        UseCase<CommonError, AdList>()
            .bg(list(ListAssembler.listRepository))
            .map { it.toModel { adId -> isFavouriteAd(ListAssembler.preferencesRepository, adId) } }
            .ui {
                it.fold(
                    {
                        view.hideProgress()
                    },
                    { responseAdList ->
                        adsList = responseAdList
                        view.render(adsList)
                        view.hideProgress()
                    }
                )
            }.run(CoreAssembler.executor)
    }

    fun onFavouritesListClick() {
        isShowingFavourites = true
        favouriteAdsList = ListModel(adsList.ads.filter { ad -> ad.isFavourite }.toMutableList())
        view.render(favouriteAdsList)
    }

    fun onFullListClick() {
        isShowingFavourites = false
        view.render(adsList)
    }

    fun onAdClicked(ad: AdModel) {
        view.navigateToAd(ad.detailUrl)
    }

    fun onAdFavouriteButtonClicked(position: Int, adId: String, isFavourite: Boolean) {
        adsList.ads.find { it.id == adId }?.isFavourite = isFavourite

        setFavouriteAd(ListAssembler.preferencesRepository, adId, isFavourite)

        if (isShowingFavourites && !isFavourite) {
            favouriteAdsList.ads.removeAt(position)
            view.removeAdAtPosition(position)
        }
    }

}