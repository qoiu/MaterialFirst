package com.qoiu.materialfirst.ui.recycler

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<in T>(
    inflater: LayoutInflater,
    container: ViewGroup,
    layoutID: Int
): RecyclerView.ViewHolder(inflater.inflate(layoutID,container,false)) {



    abstract fun bind(item: T)

}