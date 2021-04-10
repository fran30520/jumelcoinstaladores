package com.example.jumelcoinstaladores.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.databinding.ActivityFinishBinding

class finishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinishBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.main8ButtonAgain.setOnClickListener {
            val intent = Intent(this, resultActivity::class.java)
            startActivity(intent)

        }
        binding.main8ButtonChoose.setOnClickListener {
            val intent = Intent(this, officeActivity::class.java)
            startActivity(intent)
        }
        binding.main8ButtonVolver.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }


    }
}