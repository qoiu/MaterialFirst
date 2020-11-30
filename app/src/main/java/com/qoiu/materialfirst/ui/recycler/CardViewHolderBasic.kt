package com.qoiu.materialfirst.ui.recycler

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qoiu.materialfirst.R
import com.qoiu.materialfirst.data.Card

class CardViewHolderBasic(
    view: View
) : RecyclerView.ViewHolder(view) {
    val title=view.findViewById<TextView>(R.id.icw_text_title)
    val descript=view.findViewById<TextView>(R.id.icw_text_descript)
    val img=view.findViewById<ImageView>(R.id.icw_image_view)

}