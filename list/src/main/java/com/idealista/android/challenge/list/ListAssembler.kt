package com.idealista.android.challenge.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.list.data.ListDataSource
import com.idealista.android.challenge.list.data.ListRepository
import com.idealista.android.challenge.list.ui.AdsPresenter
import com.idealista.android.challenge.list.ui.ListPresenter

object ListAssembler {

    private val listDataSource: ListDataSource by lazy { ListDataSource(CoreAssembler.listApi) }

    lateinit var listPresenter: ListPresenter

    lateinit var adsPresenter: AdsPresenter

    val listRepository: ListRepository by lazy { ListRepository(listDataSource) }

}