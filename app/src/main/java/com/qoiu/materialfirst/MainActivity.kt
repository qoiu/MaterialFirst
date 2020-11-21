package com.qoiu.materialfirst

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val MIN_TEXT_LENGTH = 8
    private val EMPTY_STRING = ""
    private lateinit var  mTextInputLayout: TextInputLayout
    private lateinit var mEditText: TextInputEditText
    private lateinit var imageButton: Button
    private lateinit var appBarConfiguration: AppBarConfiguration

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
        setContentView(R.layout.main_drawer_layout)
        val toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val coordLayout : CoordinatorLayout = findViewById(R.id.coord_layout)

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,R.id.nav_second), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        
        findViewById<FloatingActionButton>(R.id.floatingActionButton).apply {
            setOnClickListener {
                Snackbar.make(coordLayout,
                    "Here should be very important information",
                    Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_drawer_menu, menu)
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        when(id){
            R.id.av_action_img_OK->
                Toast.makeText(this,"OKAY",Toast.LENGTH_LONG).show()
            R.id.av_action_img_Close->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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