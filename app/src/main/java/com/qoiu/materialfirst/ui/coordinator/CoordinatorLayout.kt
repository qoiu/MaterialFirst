package com.qoiu.materialfirst.ui.coordinator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.qoiu.materialfirst.R


class CoordinatorLayout : Fragment(R.layout.fragment_coordinator_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab : FloatingActionButton? = this.activity?.findViewById(R.id.floatingActionButton)
        fab?.apply {
            setOnClickListener (null)

        }
    }
}