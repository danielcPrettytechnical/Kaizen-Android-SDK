package com.prettytechnical.kaizenstorybook.presenter.componentsList.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.prettytechnical.kaizenstorybook.R
import com.prettytechnical.kaizenstorybook.presenter.componentsList.model.ComponentItem
import com.prettytechnical.kaizenstorybook.presenter.componentsList.view.listener.ComponentListListener

class ComponentsListAdapter(
    private val values: List<ComponentItem>,
    private val onClick: ComponentListListener
) : RecyclerView.Adapter<ComponentsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.component_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.componentElement.text = item.name
        holder.componentElement.setOnClickListener {
            onClick.onClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val componentElement: Button = view.findViewById(R.id.btnComponent)
    }
}