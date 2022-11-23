package com.prettytechnical.kaizenstorybook.presenter.standingsComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.presentation.scenes.standingsScene.view.StandingsComponentView
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.standingsComponent.viewmodel.StandingsComponentViewModel

class StandingsComponentFragment : Fragment() {

    companion object {
        fun newInstance() = StandingsComponentFragment()
    }

    private lateinit var viewModel: StandingsComponentViewModel
    private lateinit var standingsComponentView: StandingsComponentView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.standings_component_fragment, container, false)
        viewModel = ViewModelProvider(this).get(StandingsComponentViewModel::class.java)
        standingsComponentView = view.findViewById(R.id.stStandingsComponent)
        standingsComponentView.componentParams = ComponentParams(MatchId.value)
        standingsComponentView.loadView()
        return view
    }
}