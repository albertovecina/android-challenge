package com.idealista.android.challenge.list.ui

import android.util.Log
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.domain.AdDetail
import com.idealista.android.challenge.list.domain.adDetail

class AdsPresenter {

    fun onAdNeeded() {
        UseCase<CommonError, AdDetail>()
            .bg(
                adDetail(
                    ListAssembler.listRepository,
                    "https://run.mocky.io/v3/30a5752e-f534-46cb-9299-60d85c0a69e4"
                )
            )
            .map { it.toModel() }
            .ui {
                it.fold(
                    {
                        Log.d("asd", it.toString())
                    },
                    {
                        Log.d("asd", it.toString())
                    }
                )
            }.run(CoreAssembler.executor)
    }

}