package com.prettytechnical.kaizenstorybook.presenter.teamlineupComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.presentation.scenes.teamLineUpScene.view.TeamLineUpComponent
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.teamlineupComponent.viewmodel.TeamLineUpComponentViewModel

class TeamLineUpComponentFragment : Fragment() {

    companion object {
        fun newInstance() = TeamLineUpComponentFragment()
    }

    private lateinit var viewModel: TeamLineUpComponentViewModel
    private lateinit var teamLineUpComponent: TeamLineUpComponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.team_line_up_component_fragment, container,
            false)
        teamLineUpComponent = view.findViewById(R.id.teamLineupComponent)
        teamLineUpComponent.componentParams = ComponentParams(MatchId.value)
        teamLineUpComponent.loadView()
        viewModel = ViewModelProvider(this).get(TeamLineUpComponentViewModel::class.java)
        return view
    }
}