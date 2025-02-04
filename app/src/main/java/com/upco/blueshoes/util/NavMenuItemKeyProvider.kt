package com.upco.blueshoes.util

import androidx.recyclerview.selection.ItemKeyProvider
import com.upco.blueshoes.domain.NavMenuItem

/**
 * Subclasse de [ItemKeyProvider] que fornece acesso a chaves de seleção
 * estáveis, podendo ser de três tipos: Parcelable (e suas subclasses);
 * String e Long.
 */
class NavMenuItemKeyProvider(val items: List<NavMenuItem>) :
        ItemKeyProvider<Long>(ItemKeyProvider.SCOPE_MAPPED) {

    /**
     * Retorna a chave de seleção na posição fornecida do adaptador ou
     * então retorna null.
     */
    override fun getKey(position: Int) = items[position].id

    /**
     * Retorna a posição correspondente à chave de seleção, ou
     * RecyclerView.NO_POSITION em caso de null em [getKey()][getKey].
     */
    override fun getPosition(key: Long) =
            items.indexOf(items.single { item -> item.id == key })
}