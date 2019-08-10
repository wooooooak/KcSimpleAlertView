package wooooooak.dev.kcsimplealertview.woakalertview.model

import android.graphics.Color
import android.graphics.Typeface

open class BaseAlertViewModel {
    open var textColor: Int = Color.parseColor("#000000")
    open var textSize: Int = 14
    open var fontFamily: Typeface? = null
}