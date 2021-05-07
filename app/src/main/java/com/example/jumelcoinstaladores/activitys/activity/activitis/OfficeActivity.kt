package com.example.jumelcoinstaladores.activitys.activity.activitis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.activitys.activity.ViewModels.CitasViewModel
import com.example.jumelcoinstaladores.activitys.activity.ViewModels.ServiciosViewModel
import com.example.jumelcoinstaladores.databinding.ActivityOfficeBinding

class OfficeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfficeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOfficeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //recuperamos el viewModel

        val modelServicios:ServiciosViewModel by viewModels()
        modelServicios.getServicio().observe(this){


        }

        val modelCita:CitasViewModel by viewModels()
        modelCita.GetCitas().observe(this){


        }



        binding.main3ButtonVolver.setOnClickListener {
            val intent= Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
        binding.main3ButtonCitas.setOnClickListener {
            val intent= Intent(this, ResultActivity()::class.java)
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
            val intent= Intent(this, ElectricActivity::class.java)
            startActivity(intent)
        }
        binding.main3Alarm.setOnClickListener {
            val intent= Intent(this, AlarmActivity::class.java)
            startActivity(intent)
        }
        binding.main3Air.setOnClickListener {
            val intent= Intent(this, AirAconditionalActivity::class.java)
            startActivity(intent)
        }
        binding.main3Teleco.setOnClickListener {
            val intent= Intent(this, TelecoActivity::class.java)
            startActivity(intent)
        }

    }

}