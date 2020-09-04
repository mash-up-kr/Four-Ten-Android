package com.mashup.fourten.ui.main

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.DimenRes
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.linecorp.apng.ApngDrawable
import com.linecorp.apng.RepeatAnimationCallback
import com.mashup.fourten.R
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.databinding.ActivityMainBinding
import com.mashup.fourten.databinding.ItemMainCardBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.base.BaseRecyclerAdapter
import com.mashup.fourten.ui.main.list.HabitListActivity
import com.mashup.fourten.util.EventObserver
import com.mashup.fourten.util.ext.start
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Math.abs

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModel()

    private val viewPagerAdapter by lazy { mainViewPagerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setObserves()
        setViewPager()

        apngTest()

    }

    private fun MainViewModel.setObserves() {
        habitList.observe(this@MainActivity, Observer { viewPagerAdapter.updateItems(it) })

        startSettingActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent SettingActivity
        })
        startHabitCompletedActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent HabitCompletedActivity
        })
        startHabitMakeActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent HabitMakeActivity
        })
        startHabitListActivity.observe(this@MainActivity, EventObserver {
            start(HabitListActivity::class)
        })
    }

    private fun setViewPager() {
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.setPageTransformer(MarginPageTransformer(20))
        binding.viewPager.setPadding(40,0,40,0)

        binding.viewPager.run {
            offscreenPageLimit = 1
            setPageTransformer(getPageTransformer())
            addItemDecoration(HorizontalMarginItemDecoration(
                context,
                R.dimen.viewpager_current_item_horizontal_margin
            ))
        }
    }

    private fun getPageTransformer() : ViewPager2.PageTransformer {
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        }
        return pageTransformer
    }


    private fun apngTest() {
//        val drawable = ApngDrawable.decode(this.resources, R.raw.jado)
//        binding.cute.setImageDrawable(drawable)

        val r = Runnable {
            val drawable = ApngDrawable.decode(this.resources, R.raw.jado2)
            drawable.registerAnimationCallback(animationCallback)
            runOnUiThread {
//                binding.iv.setImageDrawable(drawable)
                drawable.start()
            }
        }
        val thread = Thread(r)
        thread.start()
    }

    private val animationCallback = object : AnimationCallbacks() {
        override fun onAnimationStart(drawable: Drawable?) {
//            Log.d("apng", "Animation start")
//            text_callback.text = "Animation started"
        }

        override fun onAnimationRepeat(drawable: ApngDrawable, nextLoopIndex: Int) {
//            val loopCount = drawable.loopCount
//            Log.d("apng", "Animation repeat loopCount: $loopCount, nextLoopIndex: $nextLoopIndex")
//            text_callback.text = "Animation repeat " +
//                    "loopCount: $loopCount, " +
//                    "nextLoopIndex: $nextLoopIndex"
        }

        override fun onAnimationEnd(drawable: Drawable?) {
//            Log.d("apng", "Animation end")
//            text_callback.text = "Animation ended"
        }
    }

    private abstract class AnimationCallbacks
        : Animatable2Compat.AnimationCallback(), RepeatAnimationCallback
}

class mainViewPagerAdapter : BaseRecyclerAdapter<Habit, ItemMainCardBinding>(
    R.layout.item_main_card
)

class HorizontalMarginItemDecoration(context: Context, @DimenRes horizontalMarginInDp: Int) :
    RecyclerView.ItemDecoration() {

    private val horizontalMarginInPx: Int =
        context.resources.getDimension(horizontalMarginInDp).toInt()

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.right = horizontalMarginInPx
        outRect.left = horizontalMarginInPx
    }

}