package com.prettytechnical.kaizenstorybook.presenter.swipeComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.domain.entities.LocalizationEnum
import com.prettytechnical.kaizen_sdk.presentation.scenes.swipeScene.swipeMaster.view.SwipeViewFragment
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.swipeComponent.viewmodel.SwipeComponentViewModel

class SwipeComponentFragment : Fragment() {

    companion object {
        fun newInstance() = SwipeComponentFragment()
    }

    private lateinit var viewModel: SwipeComponentViewModel
    private lateinit var frameLayout: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.swipe_component_fragment, container, false)
        initSwipeComponent(view)
        viewModel = ViewModelProvider(this).get(SwipeComponentViewModel::class.java)
        return view
    }

    private fun initSwipeComponent(view: View) {
        frameLayout = view.findViewById(R.id.swipeFrameLayout)
        val swipeFragment = SwipeViewFragment.newInstance(true, true,
            true)
        val params = ComponentParams(MatchId.value, LocalizationEnum.english)
        swipeFragment.configure(params)
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.swipeFrameLayout, swipeFragment)
        transaction.commit()
    }
}