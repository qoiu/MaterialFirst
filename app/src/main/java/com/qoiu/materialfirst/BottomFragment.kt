package com.qoiu.materialfirst

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class BottomFragment: BottomSheetDialogFragment() {
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

    /*
    class ActionListener:TextView.OnEditorActionListener {
        override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
            var BottomFragmentWeakReference : WeakReference<BottomFragment>
            fun ActionListener(bottomFragment: BottomFragment){
                BottomFragmentWeakReference=WeakReference(bottomFragment)
                return ActionListener(BottomFragmentWeakReference)
            }
        }


    }*/



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mEditText = view.findViewById<TextInputEditText>(R.id.et_password)
        mTextInputLayout = view.findViewById<TextInputLayout>(R.id.inputLayout2)
        //mTextInputLayout.setHint(getString(R.string.hint))
        mEditText.error="Too long"
        mEditText.setOnEditorActionListener { textView, i, keyEvent ->
            if(shouldShowError()){
                showError()
            }else{
                hideError()
            }
            true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? =
        inflater.inflate(R.layout.fragment_bottom,container,false)


}