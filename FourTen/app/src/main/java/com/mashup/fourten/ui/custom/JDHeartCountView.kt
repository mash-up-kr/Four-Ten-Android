package com.mashup.fourten.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.mashup.fourten.R

class JDHeartCountView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var maxHeartCnt: Int = DEFAULT_MAX_HEART
    private var currentHeartCnt: Int = 0

    init {
        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(it, R.styleable.HeartCounter, defStyleAttr, 0)
            maxHeartCnt = typedArray.getInt(R.styleable.HeartCounter_maxHeart, maxHeartCnt)
            currentHeartCnt = typedArray.getInt(R.styleable.HeartCounter_fillHeart, currentHeartCnt)
            typedArray.recycle()

            makeView()
        }
    }

    private fun makeView() {
        val grayHeartCnt = maxHeartCnt - currentHeartCnt

        val emptyHeartDrawable = ContextCompat.getDrawable(context, R.drawable.love_empty)
        val fillHeartDrawable = ContextCompat.getDrawable(context, R.drawable.love_fill)

        val container = LinearLayout(context)
        for (i in 0 until grayHeartCnt) {
            val ivEmptyHeart = ImageView(context).apply { setImageDrawable(emptyHeartDrawable) }
            container.addView(ivEmptyHeart)
        }

        for (i in grayHeartCnt until maxHeartCnt) {
            val ivFillHeart = ImageView(context).apply { setImageDrawable(fillHeartDrawable) }
            container.addView(ivFillHeart)
        }

        addView(container)
    }

//    private fun getCurrentHeart() = currentHeartCnt
//    private fun setCurrentHeart(heartCnt: Int) {
//        currentHeartCnt = heartCnt
//    }

    companion object {
        private const val DEFAULT_MAX_HEART = 5
    }

}

