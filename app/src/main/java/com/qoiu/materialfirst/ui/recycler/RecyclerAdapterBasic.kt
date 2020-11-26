package com.qoiu.materialfirst.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qoiu.materialfirst.R
import com.qoiu.materialfirst.data.Card

class RecyclerAdapter(
    view: View

):RecyclerView.Adapter<CardViewHolderBasic>() {

    private var items = listOf(
            Card(1, "Card 1", "descr", R.mipmap.jack_lantern),
            Card(2, "Card 2", "description 2", R.mipmap.jack_lantern),
            Card(3, "Card 3", "description 3", R.mipmap.jack_lantern),
            Card(4, "Card 4", "description 4", R.mipmap.jack_lantern),
            Card(5, "Card 5", "description 5", R.mipmap.jack_lantern),
            Card(6, "Card 6", "description 6", R.mipmap.jack_lantern),
            Card(7, "Card 7", "description 7", R.mipmap.jack_lantern),
            Card(8, "Card 8", "description 8", R.mipmap.jack_lantern)
    )

    companion object{
        private const val ITEM_TYPE1=0
        private const val ITEM_TYPE=1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolderBasic {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_view, parent,false)
        return CardViewHolderBasic(view)
    }


    override fun getItemCount(): Int = items.count()

//
//    fun getItemViewType(position: Int): Int =
//        when(items?.get(position)){
//            is Card-> ITEM_TYPE
//            else -> throw IllegalStateException("Unsupported type")
//        }
//
//    override fun onBindViewHolder(holder: RecyclerView, position: Int) {
//        when(holder){
//            is CardViewHolder -> holder.bind((items?.get(position) as? Card)!!)
//        }
//    }

    override fun onBindViewHolder(holder: CardViewHolderBasic, position: Int) {

        val card: Card = items.get(position) as Card
        holder.title.setText(card.title)
        holder.descript.setText(card.description)
        holder.img.setImageResource(card.imgResource)
    }

}

sealed class CardItems{
    data class Type1(val item:Card) : CardItems()

    data class Type2(val item: Card) : CardItems()
}