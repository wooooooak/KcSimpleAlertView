package wooooooak.dev.kcsimplealertview.woakalertview.model

import android.graphics.Color
import android.graphics.Typeface

open class BaseAlertViewModel {
    open var textColor: Int = Color.parseColor("#000000")
    open var textSize: Float = 14f
    open var fontFamily: Typeface? = null
    open var paddingLeft: Int = 16
    open var paddingRight: Int = 16
    open var paddingTop: Int = 16
    open var paddingBottom: Int = 16
}