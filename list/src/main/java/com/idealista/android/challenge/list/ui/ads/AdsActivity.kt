package com.idealista.android.challenge.list.ui.ads

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.list.R
import kotlinx.android.synthetic.main.activity_ads.*

class AdsActivity : AppCompatActivity(),
    AdsView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads)
        AdsAssembler.presenter =
            AdsPresenter(this)
        AdsAssembler.presenter.onAdNeeded(
            intent.getStringExtra(Addressable.Activity.Ads.EXTRA_URL) ?: ""
        )
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun render(model: AdDetailModel) {
        with(model) {
            vpPictures.adapter =
                PicturePageAdapter(
                    model.pictures
                )
            tvTitle.text = title
            tvPrice.text = price
            tvComment.text = comment
        }
    }

}
