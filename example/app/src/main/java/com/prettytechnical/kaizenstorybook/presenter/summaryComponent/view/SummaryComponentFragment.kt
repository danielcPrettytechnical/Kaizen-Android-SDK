package com.prettytechnical.kaizenstorybook.presenter.summaryComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.presentation.scenes.summaryScene.view.SummaryComponentView
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.summaryComponent.viewmodel.SummaryComponentViewModel

class SummaryComponentFragment : Fragment() {

    companion object {
        fun newInstance() = SummaryComponentFragment()
    }

    private lateinit var viewModel: SummaryComponentViewModel
    private lateinit var summaryComponentView: SummaryComponentView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.summary_component_fragment, container, false)
        summaryComponentView = view.findViewById(R.id.summaryComponentView)
        summaryComponentView.componentParams = ComponentParams(MatchId.value)
        summaryComponentView.loadView()
        viewModel = ViewModelProvider(this).get(SummaryComponentViewModel::class.java)
        return view
    }

}