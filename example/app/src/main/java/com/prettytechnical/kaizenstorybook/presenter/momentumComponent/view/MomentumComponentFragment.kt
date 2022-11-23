package com.prettytechnical.kaizenstorybook.presenter.momentumComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.presentation.scenes.momentumScene.view.MomentumComponent
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.momentumComponent.viewmodel.MomentumComponentViewModel

class MomentumComponentFragment : Fragment() {

    companion object {
        fun newInstance() = MomentumComponentFragment()
    }

    private lateinit var momentumComponent: MomentumComponent
    private lateinit var viewModel: MomentumComponentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.momentum_component_fragment, container, false)
        momentumComponent = view.findViewById(R.id.viewMomentumComponent)
        momentumComponent.componentParams = ComponentParams(MatchId.value)
        momentumComponent.loadView()
        viewModel = ViewModelProvider(this).get(MomentumComponentViewModel::class.java)
        return view
    }
}