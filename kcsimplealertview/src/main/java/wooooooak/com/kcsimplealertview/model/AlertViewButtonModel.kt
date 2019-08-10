package wooooooak.dev.kcsimplealertview.woakalertview.model

class AlertViewButtonModel(
    var text: String = "",
    override var textSize: Int = 17,
    var backgroundColor: Int = 0,
    var onClick: (() -> Unit) = {}
) : BaseAlertViewModel()