package com.idealista.android.challenge.list.ui.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.core.intentTo
import com.idealista.android.challenge.list.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(),
    ListView {

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        ListAssembler.presenter =
            ListPresenter(this)

        initViews()

        ListAssembler.presenter.onListNeeded()
    }

    private fun initViews() {
        listAdapter = ListAdapter()
        recycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = listAdapter
        }
        tlFilter.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> ListAssembler.presenter.onFullListClick()
                    1 -> ListAssembler.presenter.onFavouritesListClick()
                }
            }
        })
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun render(list: ListModel) {
        listAdapter.set(list)
        listAdapter.listener(object :
            ListAdapter.AdListener {
            override fun onAdClicked(ad: AdModel) {
                ListAssembler.presenter.onAdClicked(ad)
            }

            override fun onAdFavouriteButtonClicked(
                position: Int,
                adId: String,
                isFavourite: Boolean
            ) {
                ListAssembler.presenter.onAdFavouriteButtonClicked(position, adId, isFavourite)
            }
        })
    }

    override fun removeAdAtPosition(position: Int) {
        listAdapter.notifyItemRemoved(position)
    }

    override fun navigateToAd(url: String) {
        startActivity(Addressable.Activity.Ads.intentTo()
            .apply {
                putExtra(Addressable.Activity.Ads.EXTRA_URL, url)
            })
    }

}