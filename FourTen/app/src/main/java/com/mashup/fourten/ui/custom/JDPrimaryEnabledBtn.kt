package com.mashup.fourten.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.mashup.fourten.R

class JDPrimaryEnabledBtn @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {

    private var activeText = ""
    private var inactiveText = ""

    init {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.JDPrimaryEnabledBtn, defStyleAttr, 0)
        activeText = typedArray.getString(R.styleable.JDPrimaryEnabledBtn_activeText) ?: ""
        inactiveText = typedArray.getString(R.styleable.JDPrimaryEnabledBtn_inactiveText) ?: ""
        typedArray.recycle()

        initButton()
        setTextColor(ContextCompat.getColor(context, R.color.white))
        gravity = Gravity.CENTER
    }

    private fun initButton() {
        setBackground()
        setText()
    }

    private fun setText() {
        if (activeText.isNullOrEmpty().not()) {
            text = if (isEnabled.not() && inactiveText.isNotEmpty()) inactiveText else activeText
        }
    }

    private fun setBackground() {
        background = ContextCompat.getDrawable(
            context, when (isEnabled) {
                true -> R.drawable.bg_button_grapefruit_radius_27
                false -> R.drawable.bg_button_silver_radius_27
            }
        )
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        initButton()
    }

}
