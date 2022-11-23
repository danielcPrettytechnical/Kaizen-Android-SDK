package com.prettytechnical.kaizenstorybook.presenter.matchDetailViewTabs.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.prettytechnical.kaizen_sdk.domain.entities.ComponentParams
import com.prettytechnical.kaizen_sdk.domain.entities.LocalizationEnum
import com.prettytechnical.kaizen_sdk.presentation.scenes.matchDetailScene.mainMatchDetailScene.view.MatchDetailViewFragment
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.matchDetailViewTabs.viewmodel.MatchDetailViewTabsViewModel

class MatchDetailViewTabsFragment : Fragment() {

    companion object {
        fun newInstance() = MatchDetailViewTabsFragment()
    }

    private lateinit var viewModel: MatchDetailViewTabsViewModel
    private lateinit var btnOpenTabs: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.match_detail_view_tabs_fragment,
        container, false)
        btnOpenTabs = view.findViewById(R.id.btnOpenTabs)
        viewModel = ViewModelProvider(this).get(MatchDetailViewTabsViewModel::class.java)
        setOpenTabs()
        return view
    }

    private fun setOpenTabs(){
        btnOpenTabs.setOnClickListener {
            var matchDetailViewFragment: MatchDetailViewFragment? = null
            if (matchDetailViewFragment == null) {
                matchDetailViewFragment = MatchDetailViewFragment.newInstance()
                val params = ComponentParams(MatchId.value, LocalizationEnum.english,
                    "#ffffff")
                matchDetailViewFragment.configure(params)
                matchDetailViewFragment.show(childFragmentManager, matchDetailViewFragment.tag)
            }
        }
    }

}