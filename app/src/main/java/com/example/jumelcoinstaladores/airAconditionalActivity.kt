package com.example.jumelcoinstaladores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.jumelcoinstaladores.databinding.ActivityAirAconditionalBinding

class airAconditionalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAirAconditionalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAirAconditionalBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        // acceso a los items del spinner
        val servicios = resources.getStringArray(R.array.Servicios_air)

        // acceso al spinner
        val spinner=binding.main6Spinner

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

                }
            }
        }



        binding.main6ButtonVolver.setOnClickListener {
            val intent= Intent(this,officeActivity::class.java)
            startActivity(intent)
        }
        binding.main6ButtonChoose.setOnClickListener {
            val intent=Intent(this,citaActivity::class.java)
            startActivity(intent)
        }
    }
}