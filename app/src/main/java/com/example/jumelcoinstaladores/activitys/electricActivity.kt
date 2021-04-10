package com.example.jumelcoinstaladores.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.databinding.ActivityElectricBinding



class electricActivity : AppCompatActivity() {
    private lateinit var binding: ActivityElectricBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityElectricBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // acceso a los items del spinner
        val servicios = resources.getStringArray(R.array.Servicios_electricidad)

        // acceso al spinner
        val spinner = binding.main4Spinner

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, servicios
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val option = parent.selectedItemPosition
                    val bundle=intent.extras



                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        binding.main4ButtonVolver.setOnClickListener {
            val intent = Intent(this, officeActivity::class.java)
            startActivity(intent)
        }
        binding.main4ButtonChoose.setOnClickListener {

            val observ = binding.main4TextObserv.text

            val intent = Intent(this, citaActivity::class.java)
            startActivity(intent)
        }
    }
}