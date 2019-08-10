package wooooooak.dev.kcsimplealertview.woakalertview

import androidx.appcompat.app.AppCompatActivity
import wooooooak.dev.kcsimplealertview.woakalertview.model.SimpleAlertModel

class SimpleAlertView(
    private val activity: AppCompatActivity,
    initAttr: SimpleAlertModel.() -> Unit
) {
    private val alertModel = SimpleAlertModel().apply { initAttr() }

    fun show() {
        val dialogFragment = CustomDialogFragment(alertModel)
        dialogFragment.show(activity.supportFragmentManager, dialogFragment.tag)
    }
}