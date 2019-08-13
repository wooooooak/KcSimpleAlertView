package wooooooak.dev.kcsimplealertview.woakalertview.model

class AlertViewButtonModel(
    var text: String = "",
    override var textSize: Int = 17,
    override var paddingTop: Int = 30,
    override var paddingBottom: Int = 30,
    var backgroundColor: Int = 0,
    var onClick: (() -> Unit) = {}
) : BaseAlertViewModel()