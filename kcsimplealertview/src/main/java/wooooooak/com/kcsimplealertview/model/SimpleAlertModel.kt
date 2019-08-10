package wooooooak.dev.kcsimplealertview.woakalertview.model

import android.view.View

class SimpleAlertModel(
    var customLayout: View? = null
) {
    var title: AlertViewTextModel? = null
    var message: AlertViewTextModel? = null
    val buttonList: MutableList<AlertViewButtonModel> = mutableListOf()

    fun button(init: AlertViewButtonModel.() -> Unit) {
        buttonList.add(AlertViewButtonModel().apply(init))
    }

    fun title(init: AlertViewTextModel.() -> Unit) {
        title = AlertViewTextModel().apply(init)
    }

    fun message(init: AlertViewTextModel.() -> Unit) {
        message = AlertViewTextModel().apply(init)
    }
}