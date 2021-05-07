package com.example.jumelcoinstaladores.activitys.activity.activitis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.databinding.ActivityCitaBinding

class CitaActivity : AppCompatActivity() {

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

            val intent = Intent(this, OfficeActivity::class.java)
            startActivity(intent)

        }

    }
}