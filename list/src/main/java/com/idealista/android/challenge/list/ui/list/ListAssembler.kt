package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.list.data.ListDataSource
import com.idealista.android.challenge.list.data.ListRepository
import com.idealista.android.challenge.list.data.PreferencesDataSource
import com.idealista.android.challenge.list.data.PreferencesRepository

object ListAssembler {

    private val listDataSource: ListDataSource by lazy { ListDataSource(CoreAssembler.listApi) }

    private val preferencesDataSource: PreferencesDataSource by lazy {
        PreferencesDataSource(
            CoreAssembler.preferencesProvider
        )
    }

    lateinit var presenter: ListPresenter

    val listRepository: ListRepository by lazy { ListRepository(listDataSource) }

    val preferencesRepository: PreferencesRepository by lazy {
        PreferencesRepository(
            preferencesDataSource
        )
    }

}