package com.idealista.android.challenge.list.ui.ads

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.domain.AdDetail
import com.idealista.android.challenge.list.domain.adDetail

class AdsPresenter(private val view: AdsView) {

    fun onAdNeeded(url: String) {
        UseCase<CommonError, AdDetail>()
            .bg(
                adDetail(
                    AdsAssembler.adsRepository,
                    url
                )
            )
            .map { it.toModel() }
            .ui {
                it.fold(
                    {

                    },
                    { adDetailModel ->
                        view.render(adDetailModel)
                    }
                )
            }.run(CoreAssembler.executor)
    }

}