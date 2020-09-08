package com.idealista.android.challenge.list.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.R

class AdsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads)
        ListAssembler.adsPresenter = AdsPresenter()
        ListAssembler.adsPresenter.onAdNeeded()
    }

}
