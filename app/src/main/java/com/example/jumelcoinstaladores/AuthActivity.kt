package com.example.jumelcoinstaladores

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.jumelcoinstaladores.databinding.AuthActivityBinding
import com.google.android.material.textfield.TextInputEditText
import java.nio.file.Paths.get

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: AuthActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.base_Mytheme)

        binding = AuthActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //comprobamos si hay sesion abierta ya en este dispositivo
        sessionAcceso()

        //recupermos los datos de inicio de sesion para despues de registrarnos
        val bundle = intent.extras
        val email_auth = bundle?.get("email")
        val password_auth = bundle?.get("password")



        //Actuación sobre errores de la introducción de contraseña
        binding.mainPasswordEdit.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.mainPassword.error = ""

            }
        }
        binding.mainPasswordEdit.addTextChangedListener {
            val size = it!!.length

            binding.mainPassword.error = ""
            if (size < 8) {
                binding.mainPassword.error = getString(R.string.main_error_size)
            }
        }
        binding.mainPasswordEdit.setOnClickListener {
            //casteo para obtener el textinputeditText
            val textInputEdit = it as TextInputEditText

            val size = textInputEdit.text.toString().length
            if (size < 8) {
                binding.mainPassword.error = getString(R.string.main_error_size)
            } else {
                binding.mainPassword.error = ""
            }


        }
        //Actuamos ante los errores del email
        binding.mainEmailEdit.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.mainEmail.error = ""

            }
        }
        binding.mainEmailEdit.addTextChangedListener {

            binding.mainEmail.error = ""

        }
        //Boton olvido contraseña
        binding.mainBotonOlvidar.setOnClickListener {

            val intent = Intent(this, recoveryActivity::class.java)
            startActivity(intent)


        }
        //boton registro
        binding.mainRegistro.setOnClickListener {

            val email = binding.mainEmailEdit.text
            val password = binding.mainPasswordEdit.text

            if (password.isNullOrEmpty()) {
                binding.mainPassword.error = getString(R.string.main_olvido)
                return@setOnClickListener
            }
            if (email.isNullOrEmpty()) {
                binding.mainEmail.error = getString((R.string.main_error_email))
                return@setOnClickListener
            }
            if (email.contains("@", true) && email.contains(".", true)) {

                binding.mainEmail.error = ""

                val intent = Intent(this, singupActivity::class.java)
                intent.putExtra("email", binding.mainEmailEdit.text)
                intent.putExtra("password", binding.mainPasswordEdit.text)
                startActivity(intent)

            } else {
                binding.mainEmail.error = getString(R.string.main_error_email2)
            }


        }
        //boton acceso
        binding.mainAcceder.setOnClickListener {

            //Guardado de datos
            val prefs = getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE).edit()
            prefs.putString("email", binding.mainEmailEdit.text.toString())
            prefs.putString("password", binding.mainPasswordEdit.text.toString())
            prefs.apply()

            val email = binding.mainEmailEdit.text
            val password = binding.mainPasswordEdit.text

            if (password.isNullOrEmpty() && email.isNullOrEmpty()) {
                binding.mainPassword.error = getString(R.string.main_olvido)
                binding.mainEmail.error = getString(R.string.main_error_email)
                return@setOnClickListener
            }
            if (email!!.contains("@", true) && email.contains(".", true)) {
                binding.mainEmail.error = ""
                val intent = Intent(this, officeActivity::class.java)
                startActivity(intent)

            } else {
                binding.mainEmail.error = getString(R.string.main_error_email2)
            }

            //Cuando se comprueba que todo este correcto entondes mandamos los datos a la BBDD


        }


    }
    //funcion para acceder si estamos logueados

    private fun sessionAcceso() {

        val prefs = getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE)
        val email_auth = prefs.getString("email", null)
        val password_auth = prefs.getString("password", null)

        if (email_auth != null && password_auth != null) {
            binding.authLayout.visibility=View.INVISIBLE

            val intent = Intent(this, officeActivity::class.java)
            startActivity(intent)
        }

    }

}