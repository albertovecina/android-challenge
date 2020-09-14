package com.idealista.android.challenge.core

import android.content.Intent

fun Addressable.Activity.intentTo(): Intent =
    Intent(Intent.ACTION_VIEW).setClassName(Addressable.PACKAGE_NAME, className)

object Addressable {

    private const val BASE_PACKAGE_NAME = "com.idealista.android.challenge"
    lateinit var PACKAGE_NAME: String

    sealed class Activity {

        abstract val className: String

        object Ads : Activity() {

            const val EXTRA_URL = "extra_url"

            override val className: String
                get() = "$BASE_PACKAGE_NAME.list.ui.ads.AdsActivity"
        }
    }
}
