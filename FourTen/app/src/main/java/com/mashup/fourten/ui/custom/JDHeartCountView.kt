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
                context.obtainStyledAttributes(it, R.styleable.JDHeartCounter, defStyleAttr, 0)
            maxHeartCnt = typedArray.getInt(R.styleable.JDHeartCounter_maxHeart, maxHeartCnt)
            currentHeartCnt =
                typedArray.getInt(R.styleable.JDHeartCounter_fillHeart, currentHeartCnt)
            typedArray.recycle()

            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            makeView()
        }
    }

    private fun makeView() {
        val grayHeartCnt = maxHeartCnt - currentHeartCnt

        val container = LinearLayout(context)
        for (i in 0 until grayHeartCnt) {
            container.addView(getHeartImageView(HeartViewType.EMPTY))
        }

        for (i in grayHeartCnt until maxHeartCnt) {
            container.addView(getHeartImageView(HeartViewType.FILL))
        }

        addView(container)
    }

    private fun getHeartImageView(viewType: HeartViewType): ImageView {
        val ivHeart = ImageView(context).apply {
            setImageDrawable(
                when (viewType) {
                    HeartViewType.FILL -> ContextCompat.getDrawable(context, R.drawable.love_fill)
                    HeartViewType.EMPTY -> ContextCompat.getDrawable(context, R.drawable.love_empty)
                }
            )
        }
        ivHeart.setPadding(4, 0, 4, 0)
        return ivHeart
    }

    private fun getCurrentHeart() = currentHeartCnt
    private fun setCurrentHeart(heartCnt: Int) {
        currentHeartCnt = heartCnt
    }

    enum class HeartViewType { FILL, EMPTY }
    companion object {
        private const val DEFAULT_MAX_HEART = 5
    }

}



