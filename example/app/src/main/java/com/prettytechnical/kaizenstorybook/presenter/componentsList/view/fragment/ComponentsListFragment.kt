package com.prettytechnical.kaizenstorybook.presenter.componentsList.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.core.ComponentEnum
import com.prettytechnical.kaizenstorybook.core.MatchId
import com.prettytechnical.kaizenstorybook.presenter.MainActivity
import com.prettytechnical.kaizenstorybook.presenter.componentsList.model.ComponentItem
import com.prettytechnical.kaizenstorybook.presenter.componentsList.view.adapter.ComponentsListAdapter
import com.prettytechnical.kaizenstorybook.presenter.componentsList.view.listener.ComponentListListener
import com.prettytechnical.kaizenstorybook.presenter.componentsList.viewmodel.ComponentsListFragmentViewModel
import com.prettytechnical.kaizenstorybook.presenter.h2hComponent.view.H2HFragment
import com.prettytechnical.kaizenstorybook.presenter.matchDetailViewTabs.view.MatchDetailViewTabsFragment
import com.prettytechnical.kaizenstorybook.presenter.matchIncidentComponent.view.MatchIncidentComponentFragment
import com.prettytechnical.kaizenstorybook.presenter.momentumComponent.view.MomentumComponentFragment
import com.prettytechnical.kaizenstorybook.presenter.pitchComponent.view.PitchComponentFragment
import com.prettytechnical.kaizenstorybook.presenter.standingsComponent.view.StandingsComponentFragment
import com.prettytechnical.kaizenstorybook.presenter.statsComponent.view.StatsComponentFragment
import com.prettytechnical.kaizenstorybook.presenter.summaryComponent.view.SummaryComponentFragment
import com.prettytechnical.kaizenstorybook.presenter.swipeComponent.view.SwipeComponentFragment
import com.prettytechnical.kaizenstorybook.presenter.teamlineupComponent.view.TeamLineUpComponentFragment

class ComponentsListFragment : Fragment(), ComponentListListener {

    lateinit var viewmodel: ComponentsListFragmentViewModel
    lateinit var componentsRecycleView: RecyclerView
    lateinit var componentsListAdapter: ComponentsListAdapter
    lateinit var btnLoadMatchId: Button
    lateinit var etMatchIdEntry: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.components_list_fragment, container,
                false)
        componentsRecycleView = view.findViewById(R.id.componentsList)
        etMatchIdEntry = view.findViewById(R.id.etMatchIdEntry)
        btnLoadMatchId = view.findViewById(R.id.btnLoadMatchId)

        //Init ViewModel
        viewmodel = ViewModelProvider(this).get(ComponentsListFragmentViewModel::class.java)
        viewmodel.init()

        viewmodel.getComponentList().observe(viewLifecycleOwner, {
            componentsListAdapter.notifyDataSetChanged()
        })

        initView()
        return view
    }

    private fun initView(){
        //Init RecycleView
        initRecycleView()
        //Init Button
        initSetMatchId()
    }

    private fun initRecycleView() {
        componentsListAdapter = viewmodel.getComponentList().value?.let {
            ComponentsListAdapter(it, this)
        }!!
        with(componentsRecycleView) {
            layoutManager = LinearLayoutManager(context)
            adapter = componentsListAdapter
        }
    }

    private fun initSetMatchId() {
        btnLoadMatchId.setOnClickListener {
            if (etMatchIdEntry.text.toString().isNotEmpty()) {
                MatchId.value = etMatchIdEntry.text.toString()
                btnLoadMatchId.text = "Loaded!"
                btnLoadMatchId.setBackgroundColor(resources.getColor(R.color.green))
            }
        }
    }

    companion object {
        fun newInstance() = ComponentsListFragment()
    }

    override fun onClick(component: ComponentItem) {
        val activity = activity as MainActivity
        when(component.id) {
            ComponentEnum.pitch.ordinal -> activity
                    .setFragment(PitchComponentFragment.newInstance())
            ComponentEnum.stats.ordinal -> activity
                    .setFragment(StatsComponentFragment.newInstance())
            ComponentEnum.summary.ordinal -> activity
                .setFragment(SummaryComponentFragment.newInstance())
            ComponentEnum.teamlineup.ordinal -> activity
                .setFragment(TeamLineUpComponentFragment.newInstance())
            ComponentEnum.standings.ordinal -> activity
                .setFragment(StandingsComponentFragment.newInstance())
            ComponentEnum.matchincident.ordinal -> activity
                .setFragment(MatchIncidentComponentFragment.newInstance())
            ComponentEnum.matchdetailviewtabs.ordinal -> activity
                .setFragment(MatchDetailViewTabsFragment.newInstance())
            ComponentEnum.momentum.ordinal -> activity
                .setFragment(MomentumComponentFragment.newInstance())
            ComponentEnum.swipe.ordinal -> activity
                .setFragment(SwipeComponentFragment.newInstance())
            ComponentEnum.h2h.ordinal -> activity
                .setFragment(H2HFragment.newInstance())
        }
    }
}