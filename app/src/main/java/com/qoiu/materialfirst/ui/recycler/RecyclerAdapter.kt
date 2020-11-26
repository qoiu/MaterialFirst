package com.qoiu.materialfirst.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qoiu.materialfirst.R
import com.qoiu.materialfirst.data.Card
import com.qoiu.materialfirst.data.Category

class RecyclerAdapter(
    view: View
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private var items = listOf(
            Category("Favorite","I like this"),
            Category("Funny","Really fun"),
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
            private const val ITEM_CARD=0
            private const val ITEM_CATEGORY=1
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when(viewType){
                ITEM_CARD -> CardViewHolder(LayoutInflater.from(parent.context),parent,R.layout.item_card_view)
               // .inflate(R.layout.item_card_view, parent,false))
                ITEM_CATEGORY -> CategoryViewHolder(LayoutInflater.from(parent.context),parent,R.layout.item_category)
               //     .inflate(R.layout.item_category, parent,false))
                else -> throw IllegalStateException("Unsupported type")
            }


        override fun getItemCount(): Int = items.count()


    override fun getItemViewType(position: Int): Int =
        when(items.get(position)){
            is Card-> ITEM_CARD
            is Category-> ITEM_CATEGORY
            else -> throw IllegalStateException("Unsupported type")
        }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CardViewHolder -> holder.bind(items.get(position) as Card)
            is CategoryViewHolder -> holder.bind(items.get(position) as Category)
            else->throw IllegalStateException("Unsupported type $position" )
        }
    }

}

    sealed class Item{
        data class Type1(val item: Card) : Item()

        data class Type2(val item: Category) : Item()
    }