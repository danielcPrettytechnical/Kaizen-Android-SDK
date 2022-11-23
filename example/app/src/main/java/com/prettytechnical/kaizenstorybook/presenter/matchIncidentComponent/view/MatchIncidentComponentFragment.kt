package com.prettytechnical.kaizenstorybook.presenter.matchIncidentComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.presentation.scenes.matchScene.view.MatchComponentView
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.matchIncidentComponent.viewmodel.MatchIncidentComponentViewModel

class MatchIncidentComponentFragment : Fragment() {

    companion object {
        fun newInstance() = MatchIncidentComponentFragment()
    }

    private lateinit var viewModel: MatchIncidentComponentViewModel
    private lateinit var matchComponentView: MatchComponentView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.match_incident_component_fragment, container, false)
        matchComponentView = view.findViewById(R.id.mcMatchComponent)
        matchComponentView.componentParams = ComponentParams(MatchId.value)
        matchComponentView.loadView()
        viewModel = ViewModelProvider(this).get(MatchIncidentComponentViewModel::class.java)
        return view
    }
}