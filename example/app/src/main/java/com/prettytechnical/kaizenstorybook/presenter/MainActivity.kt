package com.prettytechnical.kaizenstorybook.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.prettytechnical.kaizen_sdk.core.KaizenSDK
import com.prettytechnical.kaizen_sdk.core.TargetType
import com.prettytechnical.kaizen_sdk.presentation.scenes.pitchScene.view.PitchComponentView
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.presenter.componentsList.view.fragment.ComponentsListFragment
import com.prettytechnical.kaizenstorybook.presenter.pitchComponent.view.PitchComponentFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Initialize Kaizen SDK
        KaizenSDK.instance.initialize(context= applicationContext, apiEnum = TargetType.STG)
        if (savedInstanceState == null) {
            setFragment(ComponentsListFragment.newInstance())
        }
        setContentView(R.layout.activity_main)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            replace(R.id.fragment_container, fragment)
            addToBackStack(fragment.javaClass.name)
        }
    }
}