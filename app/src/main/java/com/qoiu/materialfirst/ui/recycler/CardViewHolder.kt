package com.qoiu.materialfirst.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.qoiu.materialfirst.data.Card
import kotlinx.android.synthetic.main.item_card_view.view.*

class CardViewHolder(
    inflater: LayoutInflater,
    container: ViewGroup,
    layoutID: Int
) : BaseViewHolder<Card>(inflater,container,layoutID) {
    override fun bind(item: Card) {
        itemView.icw_text_title.text=item.title
        itemView.icw_text_descript.text=item.description
        itemView.icw_image_view.setImageResource(item.imgResource)
    }
}