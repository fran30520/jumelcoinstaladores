package com.example.jumelcoinstaladores.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.databinding.ActivityResultBinding

class resultActivity : AppCompatActivity() {

    private lateinit var binding:ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityResultBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.main10ButtonConfirm.setOnClickListener {
            val intent= Intent(this, goodbyeActivity::class.java)
            startActivity(intent)
        }
        binding.main10ButtonVolver.setOnClickListener {
            val intent=Intent(this, officeActivity::class.java)
            startActivity(intent)
        }

    }
}