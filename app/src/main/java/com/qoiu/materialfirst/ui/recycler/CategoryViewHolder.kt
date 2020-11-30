package com.qoiu.materialfirst.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.qoiu.materialfirst.data.Category
import kotlinx.android.synthetic.main.item_card_view.view.*

class CategoryViewHolder(
    inflater: LayoutInflater,
    container: ViewGroup,
    layoutID: Int
) : BaseViewHolder<Category>(inflater,container,layoutID) {
    override fun bind(item: Category) {
        itemView.icw_text_title.text = item.title
        itemView.icw_text_descript.text = item.description
    }
}