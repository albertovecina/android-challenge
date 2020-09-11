package com.idealista.android.challenge.list.ui.ads

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.list.data.AdsDataSource
import com.idealista.android.challenge.list.data.AdsRepository

object AdsAssembler {

    private val adsDataSource: AdsDataSource by lazy { AdsDataSource(CoreAssembler.listApi) }

    lateinit var presenter: AdsPresenter

    val adsRepository: AdsRepository by lazy { AdsRepository(adsDataSource) }

}