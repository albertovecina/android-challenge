package com.idealista.android.challenge.list.ui.ads

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
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

        initViews()

        AdsAssembler.presenter.onAdNeeded(
            intent.getStringExtra(Addressable.Activity.Ads.EXTRA_URL) ?: ""
        )
    }

    private fun initViews() {
        vpPictures.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                updatePageIndicator(position + 1)
            }

        })
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
            updatePageIndicator(1)
            tvTitle.text = title
            tvPrice.text = price
            tvComment.text = comment
        }
    }

    private fun updatePageIndicator(page: Int) {
        tvPageIndicator.text = getString(
            R.string.page_indicator,
            page,
            vpPictures?.adapter?.count ?: 0
        )
    }

}
