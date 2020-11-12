package com.qoiu.materialfirst

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val MIN_TEXT_LENGTH = 8
    private val EMPTY_STRING = ""
    private lateinit var  mTextInputLayout: TextInputLayout
    private lateinit var mEditText: TextInputEditText

    private fun shouldShowError():Boolean {
        val textLength: Int = mEditText.text?.length ?: 0
        return textLength>0 && textLength<MIN_TEXT_LENGTH
    }
    private fun showError(){
        mTextInputLayout.error= getString(R.string.hint)
    }
    private fun hideError(){
        mTextInputLayout.error= EMPTY_STRING
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mEditText = findViewById<TextInputEditText>(R.id.et_password3)
        mTextInputLayout = findViewById<TextInputLayout>(R.id.inputLayout3)
        mEditText.error="Too long"
        mEditText.setOnEditorActionListener { textView, i, keyEvent ->
            if(!shouldShowError()){
                showError()
            }else{
                hideError()
            }
            true
        }
/*
       */

        findViewById<FloatingActionButton>(R.id.floatingActionButton).apply {
            setOnClickListener {
                val bottom = BottomFragment().show(supportFragmentManager,null)
            }
        }
    }
}