package com.example.jumelcoinstaladores.activitys

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.jumelcoinstaladores.databinding.ActivityGoodbyeBinding
import java.util.logging.Handler


class goodbyeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGoodbyeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGoodbyeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.main10ButtonExit.setOnClickListener {
            finishAffinity()
        }
    }


}