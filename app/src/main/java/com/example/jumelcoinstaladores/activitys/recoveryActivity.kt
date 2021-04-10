package com.example.jumelcoinstaladores.activitys

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.databinding.ActivityRecoveryBinding

class recoveryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecoveryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.main11EmailEdit.setOnFocusChangeListener { _, hasFocus ->

            if (hasFocus) {
                binding.main11Email.error = ""
            }
        }
        binding.main11PhoneEdit.setOnFocusChangeListener { _, hasFocus ->

            if (hasFocus) {
                binding.main11Phone.error = ""
            }
        }
        binding.main11BotonVolver.setOnClickListener {

            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
        binding.main11BotonRecovery.setOnClickListener {

            val email = binding.main11EmailEdit.text.toString()
            val phone = binding.main11PhoneEdit.text.toString()

            if (email.isNullOrEmpty() && phone.isNullOrEmpty()) {
                binding.main11Email.error = "Introduzca su email"
                binding.main11Phone.error = "Introduzca su telefono"
            }
            val prefs=getSharedPreferences(getString(R.string.pref_file),Context.MODE_PRIVATE)
            val email_auht=prefs.getString("email",null)
            val phone_auth=prefs.getString("phone",null)
            val password_auth=prefs.getString("password",null)

            if(email.equals(email_auht) && phone.equals(phone_auth)){
                binding.main11ResultText.setText(password_auth)
            }

        }
    }
}