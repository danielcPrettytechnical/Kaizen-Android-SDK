package com.prettytechnical.kaizenstorybook.presenter.componentsList.view.listener

import com.prettytechnical.kaizenstorybook.presenter.componentsList.model.ComponentItem

interface ComponentListListener {
    fun onClick(component: ComponentItem)
}