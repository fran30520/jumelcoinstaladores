package com.example.jumelcoinstaladores.activitys

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.databinding.ActivityOfficeBinding

class officeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfficeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOfficeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.main3ButtonVolver.setOnClickListener {
            val intent= Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
        binding.main3ButtonCitas.setOnClickListener {
            val intent= Intent(this, resultActivity()::class.java)
            startActivity(intent)
        }
        binding.main3ButtonExit.setOnClickListener {
            val prefs=getSharedPreferences(getString(R.string.pref_file),Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()
            val intent=Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
        binding.main3Electric.setOnClickListener {
            val intent= Intent(this, electricActivity::class.java)
            startActivity(intent)
        }
        binding.main3Alarm.setOnClickListener {
            val intent= Intent(this, alarmActivity::class.java)
            startActivity(intent)
        }
        binding.main3Air.setOnClickListener {
            val intent= Intent(this, airAconditionalActivity::class.java)
            startActivity(intent)
        }
        binding.main3Teleco.setOnClickListener {
            val intent= Intent(this, telecoActivity::class.java)
            startActivity(intent)
        }

    }
}