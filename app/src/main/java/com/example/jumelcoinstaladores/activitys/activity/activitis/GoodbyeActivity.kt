package com.example.jumelcoinstaladores.activitys.activity.activitis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.databinding.ActivityGoodbyeBinding


class GoodbyeActivity : AppCompatActivity() {

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