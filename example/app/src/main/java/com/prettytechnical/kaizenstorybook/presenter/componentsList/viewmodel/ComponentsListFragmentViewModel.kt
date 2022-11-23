package com.prettytechnical.kaizenstorybook.presenter.componentsList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prettytechnical.kaizenstorybook.core.ComponentEnum
import com.prettytechnical.kaizenstorybook.presenter.componentsList.model.ComponentItem

class ComponentsListFragmentViewModel: ViewModel() {

    private lateinit var componentsList: MutableLiveData<List<ComponentItem>>

    fun init(){
        componentsList = populateComponentList()
    }

    fun getComponentList(): LiveData<List<ComponentItem>> {
        return componentsList
    }

    private fun populateComponentList(): MutableLiveData<List<ComponentItem>> {
        val componentList = MutableLiveData<List<ComponentItem>>()
        val compList = ArrayList<ComponentItem>()
        compList.add(ComponentItem(ComponentEnum.pitch.ordinal,"Pitch Component"))
        compList.add(ComponentItem(ComponentEnum.stats.ordinal,"Stats Component"))
        compList.add(ComponentItem(ComponentEnum.summary.ordinal,"Summary Component"))
        compList.add(ComponentItem(ComponentEnum.teamlineup.ordinal,"TeamLineUp Component"))
        compList.add(ComponentItem(ComponentEnum.standings.ordinal,"Standings Component"))
        compList.add(ComponentItem(ComponentEnum.matchincident.ordinal,
            "Match Incident Component"))
        compList.add(ComponentItem(ComponentEnum.matchdetailviewtabs.ordinal,
            "Match Detail Tabs"))
        compList.add(ComponentItem(ComponentEnum.momentum.ordinal,
            "Momentum Component"))
        compList.add(ComponentItem(ComponentEnum.swipe.ordinal,
            "Swipe Component"))
        compList.add(ComponentItem(ComponentEnum.h2h.ordinal,
            "H2H Component"))
        componentList.value = compList
        return componentList
    }

}