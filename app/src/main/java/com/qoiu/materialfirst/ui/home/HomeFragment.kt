package com.qoiu.materialfirst.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.qoiu.materialfirst.MainActivity
import com.qoiu.materialfirst.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fab : FloatingActionButton? = this.activity?.findViewById(R.id.floatingActionButton)
        fab?.setOnClickListener {
            with(activity as MainActivity){
                setupNextTheme()
            }
        }
    }
}