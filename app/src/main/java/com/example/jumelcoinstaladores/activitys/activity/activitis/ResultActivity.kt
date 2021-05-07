package com.example.jumelcoinstaladores.activitys.activity.activitis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jumelcoinstaladores.databinding.ActivityResultBinding

class ResultActivity: AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.main10ButtonConfirm.setOnClickListener {
            val intent = Intent(this,GoodbyeActivity::class.java)
            startActivity(intent)
        }
        binding.main10ButtonVolver.setOnClickListener {
            val intent= Intent(this, OfficeActivity::class.java)
            startActivity(intent)
        }

    }
}