package com.mashup.fourten.ui.main

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import com.linecorp.apng.ApngDrawable
import com.linecorp.apng.RepeatAnimationCallback
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityMainBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.util.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModel()


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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setup()

//        val drawable = ApngDrawable.decode(this.resources, R.raw.jado)
//        binding.cute.setImageDrawable(drawable)

        val r = Runnable {
            val drawable = ApngDrawable.decode(this.resources,R.raw.jado2)
            drawable.registerAnimationCallback(animationCallback)
            runOnUiThread{
//                binding.iv.setImageDrawable(drawable)
                drawable.start()
            }
        }
        val thread = Thread(r)
        thread.start()
    }

    private fun setup() {
        binding.typeStatic = MainViewModel.Companion
        viewModel.setObserves()

    }

    private fun MainViewModel.setObserves() {
        startSettingActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent SettingActivity
        })
        startHabitCompletedActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent HabitCompletedActivity
        })
        startHabitMakeActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent HabitMakeActivity
        })
        viewType.observe(this@MainActivity, Observer {
            //TODO : change Fragment (card/list)
        })
    }


    private abstract class AnimationCallbacks
        : Animatable2Compat.AnimationCallback(), RepeatAnimationCallback
}