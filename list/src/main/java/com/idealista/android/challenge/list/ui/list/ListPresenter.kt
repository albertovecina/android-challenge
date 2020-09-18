package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.domain.AdList
import com.idealista.android.challenge.list.domain.list
import com.idealista.android.challenge.list.domain.removeAdAsFavourite
import com.idealista.android.challenge.list.domain.setAdAsFavourite

class ListPresenter(private val view: ListView) {

    private var adsList: ListModel = ListModel(arrayListOf())

    private var isShowingFavourites: Boolean = false

    fun onListNeeded() {
        view.showProgress()
        UseCase<CommonError, AdList>()
            .bg(list(ListAssembler.listRepository))
            .map { it.toModel() }
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
        view.render(ListModel(adsList.ads.filter { it.isFavourite }))
    }

    fun onFullListClick() {
        isShowingFavourites = false
        view.render(adsList)
    }

    fun onAdClicked(ad: AdModel) {
        view.navigateToAd(ad.detailUrl)
    }

    fun onAdFavouriteButtonClicked(adId: String, isFavourite: Boolean) {
        adsList.ads.find { it.id == adId }?.isFavourite = isFavourite

        UseCase<CommonError, Unit>().bg {
            if (isFavourite)
                setAdAsFavourite(ListAssembler.listRepository, adId)
            else
                removeAdAsFavourite(ListAssembler.listRepository, adId)
        }.run(CoreAssembler.executor)

        if (isShowingFavourites && !isFavourite)
            view.render(ListModel(adsList.ads.filter { it.isFavourite }))

    }

}