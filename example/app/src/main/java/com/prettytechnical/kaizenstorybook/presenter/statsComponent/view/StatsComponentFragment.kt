package com.prettytechnical.kaizenstorybook.presenter.statsComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.presentation.scenes.detailedStatsScene.view.DetailedStatsComponentView
import com.prettytechnical.kaizen_sdk.presentation.scenes.statsScene.view.StatsComponentView
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.statsComponent.viewmodel.StatsComponentViewModel

class StatsComponentFragment : Fragment() {

    companion object {
        fun newInstance() = StatsComponentFragment()
    }

    private lateinit var viewModel: StatsComponentViewModel
    private lateinit var statsComponentView: StatsComponentView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.stats_component_fragment, container, false)
        viewModel = ViewModelProvider(this).get(StatsComponentViewModel::class.java)
        statsComponentView = view.findViewById(R.id.statsComponentView)
        statsComponentView.componentParams = ComponentParams(MatchId.value)
        statsComponentView.loadView()
        return view
    }

}