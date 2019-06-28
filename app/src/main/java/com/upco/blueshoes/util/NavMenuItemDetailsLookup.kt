package com.upco.blueshoes.util

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.upco.blueshoes.view.NavMenuItemsAdapter

/**
 * [ItemDetailsLookup] permite que a biblioteca de seleção acesse informações sobre os itens
 * do [RecyclerView] que receberam um [MotionEvent]. Ele é efetivamente uma factory para
 * instâncias de [ItemDetails][ItemDetailsLookup.ItemDetails] que são submetidas a backup
 * (ou extraídas) de uma ocorrência de [RecyclerView.ViewHolder].
 */
class NavMenuItemDetailsLookup(private val rvMenuItems: RecyclerView) : ItemDetailsLookup<Long>() {

    /**
     * Retorna o [ItemDetails][ItemDetailsLookup.ItemDetails] para o item
     * sob o evento ([MotionEvent]) ou nulo caso não haja um.
     */
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view = rvMenuItems.findChildViewUnder(e.x, e.y)

        if (view != null) {
            val holder = rvMenuItems.getChildViewHolder(view)
            return (holder as NavMenuItemsAdapter.ViewHolder).itemDetails
        }

        return null
    }
}