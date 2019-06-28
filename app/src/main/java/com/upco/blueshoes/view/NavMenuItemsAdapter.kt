package com.upco.blueshoes.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.upco.blueshoes.R
import com.upco.blueshoes.domain.NavMenuItem
import com.upco.blueshoes.util.NavMenuItemDetails
import kotlinx.android.synthetic.main.nav_menu_item.view.*

class NavMenuItemsAdapter(val items: List<NavMenuItem>) :
        RecyclerView.Adapter<NavMenuItemsAdapter.ViewHolder>() {

    lateinit var selectionTracker: SelectionTracker<Long>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.nav_menu_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val itemDetails = NavMenuItemDetails()

        private val ivIcon = view.iv_icon
        private val tvLabel = view.tv_label

        fun setData(item: NavMenuItem) {
            tvLabel.text = item.label

            if (item.iconId != NavMenuItem.DEFAULT_ICON_ID) {
                ivIcon.setImageResource(item.iconId)
                ivIcon.visibility = View.VISIBLE
            } else {
                ivIcon.visibility = View.GONE
            }

            /*
             * São nos blocos condicionais a seguir que devem vir os
             * algoritmos de atualização de UI, isso para indicar o
             * item selecionado e os itens não selecionados.
             */
            itemDetails.item = item
            itemDetails.adapterPosition = adapterPosition

            if (selectionTracker.isSelected(itemDetails.selectionKey)) {
                view.setBackgroundColor(
                    ContextCompat.getColor(view.context, R.color.colorNavItemSelected)
                )
            } else {
                view.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }
}