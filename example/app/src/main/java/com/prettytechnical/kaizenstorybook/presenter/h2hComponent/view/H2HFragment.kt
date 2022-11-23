package com.prettytechnical.kaizenstorybook.presenter.h2hComponent.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.presentation.scenes.h2hScene.view.H2HComponentView
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId

class H2HFragment : Fragment() {

    companion object {
        fun newInstance() = H2HFragment()
    }

    private lateinit var h2hComponent: H2HComponentView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_h2h, container, false)
        h2hComponent = view.findViewById(R.id.viewH2HComponent)
        h2hComponent.componentParams = ComponentParams(MatchId.value)
        h2hComponent.loadView()
        return view
    }
}