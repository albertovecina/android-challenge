package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.domain.AdList
import com.idealista.android.challenge.list.domain.list

class ListPresenter(private val view: ListView) {

    fun onListNeeded() {
        UseCase<CommonError, AdList>()
            .bg(list(ListAssembler.listRepository))
            .map { it.toModel() }
            .ui {
                it.fold(
                    {

                    },
                    { list ->
                        view.render(list)
                    }
                )
            }.run(CoreAssembler.executor)
    }

    fun onAdClicked(ad: AdModel) {
        view.navigateToAd(ad.detailUrl)
    }

}