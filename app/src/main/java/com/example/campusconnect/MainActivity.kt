package com.example.campusconnect

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.campusconnect.ui.ebook.EBook
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController:NavController

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle :ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView

    private lateinit var sharedPreferences : SharedPreferences
    private  lateinit var editor : SharedPreferences.Editor
   private var checkedItem :Int =0
    private lateinit var selected :String

    private var CHECKEDITEM : String ="checked_item"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("themes",Context.MODE_PRIVATE)
        editor=sharedPreferences.edit()

        when (getCheckedItem()) {
            0 -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        bottomNavigationView=findViewById(R.id.bottomNavigationView)

        navController=Navigation.findNavController(this,R.id.fragment_layout)


        drawerLayout=findViewById(R.id.drawerLayout)
        navigationView=findViewById(R.id.navigation_view)

        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //Menu showed with the help of this line
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener(this)

        NavigationUI.setupWithNavController(bottomNavigationView,navController)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.navigation_developer -> startActivity(Intent(this@MainActivity,DeveloperActivity::class.java))
            R.id.navigation_video -> video()
            R.id.navigation_rate -> startActivity(Intent(this, RateUsActivity::class.java))
            R.id.navigation_ebook -> startActivity(Intent(this@MainActivity,EBook::class.java))
            R.id.navigation_website -> collegeWebsite()
            R.id.navigation_share -> share()
          R.id.navigation_color -> showDialog()
        }

        return true
    }

    private fun share() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, check out this cool app!")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }




    private fun collegeWebsite() {
        val url = "https://www.ietdavv.edu.in/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun video() {
        val url = "https://www.youtube.com/@drglprajapati6255/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
    private fun showDialog() {
        val themes: Array<String> = resources.getStringArray(R.array.theme)

        val builder : MaterialAlertDialogBuilder = MaterialAlertDialogBuilder(this)

        builder.setTitle("Select Theme")
        builder.setSingleChoiceItems(R.array.theme,getCheckedItem(), DialogInterface.OnClickListener{ _, i ->
            selected=themes[i];
            checkedItem=i
        })

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { _, i ->
            if(selected == null){
                selected=themes[i]
                checkedItem=i
            }

            when (selected) {
                "System Default" -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
                "Dark" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                "Light" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            setCheckedItem(checkedItem)
        })

        builder.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialogInterface, i ->

            dialogInterface.dismiss()
        })

        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun getCheckedItem():Int{
        return sharedPreferences.getInt(CHECKEDITEM,0)

    }

    private fun setCheckedItem(i:Int){
        editor.putInt(CHECKEDITEM,i)
        editor.apply()
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else
        super.onBackPressed()
    }
}