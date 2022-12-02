package com.prettytechnical.kaizenstorybook.presenter.pitchComponent.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.domain.entities.LocalizationEnum
import com.prettytechnical.kaizen_sdk.presentation.scenes.pitchScene.view.PitchComponentView
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.pitchComponent.viewmodel.PitchComponentViewModel

class PitchComponentFragment : Fragment() {

    companion object {
        fun newInstance() = PitchComponentFragment()
    }

    private lateinit var viewModel: PitchComponentViewModel
    private lateinit var pitchComponentView: PitchComponentView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.pitch_component_fragment, container, false)
        pitchComponentView = view.findViewById(R.id.pitchComponentView)
        pitchComponentView.componentParams = ComponentParams(MatchId.value,
            LocalizationEnum.english)
        pitchComponentView.loadView()
        pitchComponentView.didChangeOptimalSize = { height, _ ->
            pitchComponentView.layoutParams.height = height
            pitchComponentView.requestLayout()
        }
        viewModel = ViewModelProvider(this).get(PitchComponentViewModel::class.java)
        return view
    }

}