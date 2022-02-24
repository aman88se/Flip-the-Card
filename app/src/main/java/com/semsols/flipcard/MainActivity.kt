package com.semsols.flipcard

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var front_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet
    var Front = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scale: Float = applicationContext.resources.displayMetrics.density
        front_card.cameraDistance = 8000 * scale
        back_card.cameraDistance = 8000 * scale

        front_anim = AnimatorInflater.loadAnimator(applicationContext,R.animator.front_animator) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(applicationContext,R.animator.back_animator) as AnimatorSet

        flipBtn.setOnClickListener {

            if(Front){
                front_anim.setTarget(front_card)
                back_anim.setTarget(back_card)
                front_anim.start()
                back_anim.start()
                Front = false
            }else{

                front_anim.setTarget(back_card)
                back_anim.setTarget(front_card)
                front_anim.start()
                back_anim.start()
                Front = true
            }

        }


    }
}