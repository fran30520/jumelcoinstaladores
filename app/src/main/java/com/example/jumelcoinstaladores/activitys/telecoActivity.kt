package com.example.jumelcoinstaladores.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.databinding.ActivityTelecoBinding

class telecoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelecoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= ActivityTelecoBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        // acceso a los items del spinner
        val servicios = resources.getStringArray(R.array.Servicios_teleco)

        // acceso al spinner
        val spinner=binding.main7Spinner

        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, servicios)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


        binding.main7ButtonVolver.setOnClickListener {
            val intent= Intent(this, officeActivity::class.java)
            startActivity(intent)
        }

        binding.main7ButtonChoose.setOnClickListener {
            val intent=Intent(this, citaActivity::class.java)
            startActivity(intent)
        }
    }
}