package com.mashup.fourten.ui.main

import android.os.Bundle
import android.graphics.drawable.Drawable
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
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

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModel()

    private val viewPagerAdapter by lazy { MainViewPagerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setObserves()
        setViewPager()

        apngTest()

    }

    private fun MainViewModel.setObserves() {
        habits.observe(this@MainActivity, Observer { viewPagerAdapter.updateItems(it) })

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
        with(binding.viewPager) {
            adapter = viewPagerAdapter
            offscreenPageLimit = 1
            (getChildAt(0) as? RecyclerView)?.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        setPagerMargin()
    }

    private fun setPagerMargin() {
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        binding.viewPager.setPageTransformer { page, position ->
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (ViewCompat.getLayoutDirection(binding.viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                page.translationX = -offset
            } else {
                page.translationX = offset
            }
        }
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

class MainViewPagerAdapter : BaseRecyclerAdapter<Habit, ItemMainCardBinding>(
    R.layout.item_main_card
)
