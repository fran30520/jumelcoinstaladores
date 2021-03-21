package com.example.jumelcoinstaladores

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.databinding.ActivityCitaBinding

class citaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCitaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityCitaBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.main9ButtonExit.setOnClickListener {
            finishAffinity()

        }
        binding.main9ButtonReturn.setOnClickListener {

            val intent = Intent(this,officeActivity::class.java)
            startActivity(intent)

        }

    }
}