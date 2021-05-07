package com.example.jumelcoinstaladores.activitys.activity.activitis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.databinding.ActivityAlarmBinding


class AlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.base_Mytheme)

      binding= ActivityAlarmBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        // acceso a los items del spinner
        val servicios = resources.getStringArray(R.array.Servicios_Alarm)

        // acceso al spinner
        val spinner=binding.main5Spinner

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


        binding.main5ButtonVolver.setOnClickListener {
            val intent= Intent(this, OfficeActivity::class.java)
            startActivity(intent)
        }

        binding.main5ButtonChoose.setOnClickListener {
            val intent=Intent(this, CitaActivity::class.java)
            startActivity(intent)
        }
    }
}