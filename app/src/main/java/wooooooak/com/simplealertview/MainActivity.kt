package wooooooak.com.simplealertview

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import wooooooak.com.kcsimplealertview.AlertStyle
import wooooooak.dev.kcsimplealertview.woakalertview.SimpleAlertView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showAlertView()

        button.setOnClickListener {
            showAlertView()
        }
    }

    private fun showAlertView() {
        val simpleAlertView = SimpleAlertView(this) {
            title {
                text = "Title!"
                textSize = resources.getDimension(R.dimen.sample_text_size)
            }
            message {
                text = "this is message"
                textSize = resources.getDimension(R.dimen.sample_text_size2)
                textColor = ContextCompat.getColor(this@MainActivity, R.color.colorGray7)
            }
            customLayout = LayoutInflater.from(this@MainActivity).inflate(R.layout.custom_layout,
                null, false)
            button {
                text = "1st button"
                onClick = {
                    Toast.makeText(this@MainActivity, "on click 1st button", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            button {
                text = "2nd button"
                fontFamily =
                    ResourcesCompat.getFont(this@MainActivity, R.font.noto_sans_extra_bold_italic)
            }
        }
//        simpleAlertView.cancelable = false
//        simpleAlertView.setStyleTheme(AlertStyle.WHITE_BORDER)
        simpleAlertView.show()
    }
}
