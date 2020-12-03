package com.qoiu.materialfirst.data

import android.util.Log
import com.qoiu.materialfirst.R

object themeData {
    const val THEME_WINTER=0
    const val THEME_HALLOWEEN=1
    val themes = listOf(
        R.style.AppTheme,
        R.style.AppThemeHalloween
    )
    var curTheme= R.style.AppTheme

}