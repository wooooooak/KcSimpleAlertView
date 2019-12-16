package wooooooak.dev.kcsimplealertview.woakalertview

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import wooooooak.com.kcsimplealertview.AlertStyle
import wooooooak.com.kcsimplealertview.R
import wooooooak.dev.kcsimplealertview.woakalertview.model.SimpleAlertModel

class SimpleAlertView(
    private val activity: AppCompatActivity,
    initAttr: SimpleAlertModel.() -> Unit
) {
    var cancelable = true
    private val alertModel = SimpleAlertModel().apply { initAttr() }
    private var styleTheme: AlertStyle = AlertStyle.WHITE_BORDER
    private var customLayoutDrawable: Drawable? = null

    fun show() {
        customLayoutDrawable?.let {
            val dialogFragment = CustomDialogFragment(alertModel, it).apply {
                isCancelable = cancelable
            }
            dialogFragment.show(activity.supportFragmentManager, dialogFragment.tag)
        } ?: run {
            val layoutDrawable = getDrawableByTheme()
            val dialogFragment = CustomDialogFragment(alertModel, layoutDrawable).apply {
                isCancelable = cancelable
            }
            dialogFragment.show(activity.supportFragmentManager, dialogFragment.tag)
        }
    }

    fun setStyleTheme(value: AlertStyle) {
        styleTheme = value
    }

    private fun getDrawableByTheme() =
        when (styleTheme) {
            AlertStyle.WHITE_BORDER -> ContextCompat.getDrawable(
                activity, R.drawable.alert_white_border
            )
            AlertStyle.WHITE_RECTANGLE -> ContextCompat.getDrawable(
                activity, R.drawable.alert_white_rectangle
            )
        }

}