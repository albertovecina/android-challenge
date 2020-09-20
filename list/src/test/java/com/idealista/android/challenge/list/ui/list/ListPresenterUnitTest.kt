package com.idealista.android.challenge.list.ui.list

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class ListPresenterUnitTest {

    private val adModel: AdModel = mock()
    private val view: ListView = mock()
    private val presenter: ListPresenter = ListPresenter(view)

    @Test
    fun whenFullListTabClickThenRender() {
        presenter.onFullListClick()
        verify(view).render(any())
    }

    @Test
    fun whenFavouritesTabClickThenRender() {
        presenter.onUpdatedListNeeded()
        verify(view).render(any())
    }

    @Test
    fun whenAdClickedThenNavigateToAdDetail() {
        presenter.onAdClicked(adModel)
        verify(view).navigateToAd(adModel.detailUrl)
    }

}