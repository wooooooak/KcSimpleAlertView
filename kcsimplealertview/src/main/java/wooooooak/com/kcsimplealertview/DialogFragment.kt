package wooooooak.dev.kcsimplealertview.woakalertview

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.alert_layout.view.*
import wooooooak.com.kcsimplealertview.R
import wooooooak.dev.kcsimplealertview.woakalertview.model.AlertViewButtonModel
import wooooooak.dev.kcsimplealertview.woakalertview.model.AlertViewTextModel
import wooooooak.dev.kcsimplealertview.woakalertview.model.SimpleAlertModel

class CustomDialogFragment(
    private val simpleAlertModel: SimpleAlertModel,
    private val layoutDrawable: Drawable?
) : DialogFragment() {

    private lateinit var dialogView: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialogView = inflater.inflate(R.layout.alert_layout, container, false).apply {
            background = layoutDrawable
            with(simpleAlertModel) {
                title?.let { setTextViewAttr(title_text, it) } ?: run {
                    title_text.visibility = View.GONE
                }
                message?.let { setTextViewAttr(message_text, it) } ?: run {
                    message_text.visibility = View.GONE
                }
                customLayout?.let { custom_view.addView(it) } ?: run {
                    custom_view.visibility = View.GONE
                }
                buttonList.forEachIndexed { index, buttonModel ->
                    if (index > 0) button_container.addView(makeDividerView(requireContext()))
                    button_container.addView(makeCustomTextView(buttonModel))
                }
            }
        } as LinearLayout

        return dialogView
    }

    private fun setTextViewAttr(view: TextView, attr: AlertViewTextModel) {
        attr.run {
            text?.let { view.text = it }
            fontFamily?.let { view.typeface = it }
        }
        view.run {
            setPadding(attr.paddingLeft, attr.paddingTop, attr.paddingRight, attr.paddingBottom)
            setTextColor(attr.textColor)
            setTextSize(
                TypedValue.COMPLEX_UNIT_PX, attr.textSize ?: resources
                    .getDimension(R.dimen.alert_view_default_text_size)
            )
        }
    }

    private fun makeDividerView(context: Context) = View(context).apply {
        layoutParams = LinearLayout.LayoutParams(2, LinearLayout.LayoutParams.MATCH_PARENT)
        alpha = 0.1f
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorDivider))
    }

    private fun makeCustomTextView(buttonModel: AlertViewButtonModel) =
        TextView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )
            gravity = Gravity.CENTER
            text = buttonModel.text
            setTextSize(
                TypedValue.COMPLEX_UNIT_PX, buttonModel.textSize ?: resources
                    .getDimension(R.dimen.alert_view_default_text_size)
            )
            buttonModel.fontFamily?.let { typeface = it }
            setPadding(
                buttonModel.paddingLeft, buttonModel.paddingTop, buttonModel.paddingRight,
                buttonModel.paddingBottom
            )
            setTextColor(buttonModel.textColor)
            setBackgroundColor(buttonModel.backgroundColor)
            setOnClickListener {
                buttonModel.onClick()
                this@CustomDialogFragment.dismiss()
            }
        }
}