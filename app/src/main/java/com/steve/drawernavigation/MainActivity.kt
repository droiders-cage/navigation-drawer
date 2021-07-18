package com.steve.drawernavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.steve.drawernavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        toggle=ActionBarDrawerToggle(this, binding.drawerlayout,R.string.open, R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> Toast.makeText(applicationContext,"selected home",Toast.LENGTH_LONG).show()
                R.id.about_us -> Toast.makeText(applicationContext,"clicked about us",Toast.LENGTH_LONG).show()
                R.id.trip ->Toast.makeText(applicationContext,"clicked trips",Toast.LENGTH_LONG).show()
                R.id.logout -> setProfile()

            }
            true
        }


    }

    private fun setProfile() {
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}
