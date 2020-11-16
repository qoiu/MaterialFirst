package com.qoiu.materialfirst

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val MIN_TEXT_LENGTH = 8
    private val EMPTY_STRING = ""
    private lateinit var  mTextInputLayout: TextInputLayout
    private lateinit var mEditText: TextInputEditText
    private lateinit var imageButton: Button

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

        val btn: Button=findViewById(R.id.button_phone)

        val toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        btn.setOnClickListener {
            Toast.makeText(this,"pressed",Toast.LENGTH_LONG).show()
        }

        
        findViewById<FloatingActionButton>(R.id.floatingActionButton).apply {
            setOnClickListener {

                val bottom = BottomFragment().show(supportFragmentManager,null)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.getItemId()
        when(id){
            R.id.av_action_img_OK->
                Toast.makeText(this,"OKAY",Toast.LENGTH_LONG).show()
            R.id.av_action_img_Close->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun addListenerOnButton()
    {

        imageButton = findViewById(R.id.button_phone) as Button

        imageButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(arg0: View?) {
                val bottom = BottomFragment().show(supportFragmentManager,null)
                Toast.makeText(
                    applicationContext,
                    "ImageButton (selector) is clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}