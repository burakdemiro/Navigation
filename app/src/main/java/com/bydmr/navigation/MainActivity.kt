package com.bydmr.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Bu MainActivity için navController'ı yarat (2.parametre bu activity'de bulunan fragment)
        val navConroller = Navigation.findNavController(this, R.id.fragment)

        setupBottomNavMenu(navConroller)
        setupSideNavMenu(navConroller)
        setupActionBar(navConroller)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        // Ekranı yatay döndürdüğünde null olacaktır
        bottomNav?.let {
            // NavigationUI kütüphanesi bottomNav ve NavDrawer'ın, menu itemların ögelerini ile destination'ları eşleyen metota sahip
            // Yalnız eşlemesi için menu'deki item id ile Navigationdaki fragmentin id eşit olmalı
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun setupSideNavMenu(navController: NavController) {
        navView?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    // Hamburger menü ikonu ve geri ikonu yarat
    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val navConroller = Navigation.findNavController(this, R.id.fragment)
        val navigated = NavigationUI.onNavDestinationSelected(item!!, navConroller)
        return navigated || super.onOptionsItemSelected(item)
    }

    // Hamburger iconun ve geri tuşlarının ne yapacaklarını belirle
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.fragment), drawerLayout)
    }
}
