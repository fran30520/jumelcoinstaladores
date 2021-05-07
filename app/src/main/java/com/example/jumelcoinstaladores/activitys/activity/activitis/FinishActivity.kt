package com.example.jumelcoinstaladores.activitys.activity.activitis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinishBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.main8ButtonAgain.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)

        }
        binding.main8ButtonChoose.setOnClickListener {
            val intent = Intent(this, OfficeActivity::class.java)
            startActivity(intent)
        }
        binding.main8ButtonVolver.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }


    }
}