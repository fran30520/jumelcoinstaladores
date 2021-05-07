package com.example.jumelcoinstaladores.activitys.activity.activitis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModel
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.activitys.activity.ViewModels.ClientesViewModel
import com.example.jumelcoinstaladores.activitys.activity.ViewModels.authViewModel
import com.example.jumelcoinstaladores.activitys.activity.services.Clientes
import com.example.jumelcoinstaladores.databinding.AuthActivityBinding
import com.google.android.material.textfield.TextInputEditText

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: AuthActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val modelAuth: authViewModel by viewModels()
        val modelClientes: ClientesViewModel by viewModels()


        //comprobamos si hay sesion abierta ya en este dispositivo
/*

            val pref = getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE)
            val email = pref.getString("email", null)
            val password = pref.getString("password", null)

            sessionAcceso(email!!, password!!)
*/


        setTheme(R.style.base_Mytheme)

        binding = AuthActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


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

            val intent = Intent(this, RecoveryActivity::class.java)
            startActivity(intent)


        }
        //boton registro
        binding.mainRegistro.setOnClickListener {

            val email = binding.mainEmailEdit.text
            val password = binding.mainPasswordEdit.text

            if (password.isNullOrEmpty()) {
                binding.mainPassword.error = "Debes introducir una contraseña"
                return@setOnClickListener
            }
            if (email.isNullOrEmpty()) {
                binding.mainEmail.error = getString((R.string.main_error_email))
                return@setOnClickListener
            }
            if (email.contains("@", true) && email.contains(".", true)) {

                binding.mainEmail.error = ""

                val intent = Intent(this, SingupActivity::class.java)
                intent.putExtra("email", binding.mainEmailEdit.text)
                intent.putExtra("password", binding.mainPasswordEdit.text)
                startActivity(intent)

            } else {
                binding.mainEmail.error = getString(R.string.main_error_email2)
            }


        }
        //boton acceso
        binding.mainAcceder.setOnClickListener {

            val email = binding.mainEmailEdit.text
            val password = binding.mainPasswordEdit.text

            if (password.isNullOrEmpty() && email.isNullOrEmpty()) {
                binding.mainPassword.error = getString(R.string.main_olvido)
                binding.mainEmail.error = getString(R.string.main_error_email)
                return@setOnClickListener
            }
            if (email!!.contains("@", true) && email.contains(".", true)) {
                binding.mainEmail.error = ""

            } else {
                binding.mainEmail.error = getString(R.string.main_error_email2)
            }

            //Comprobamos el usuario esta logeado

            val ClienteLogin = Clientes.ClienteLogin(
                binding.mainEmailEdit.text.toString(),
                binding.mainPasswordEdit.text.toString()
            )

            modelAuth.cargarLogin(ClienteLogin).observe(this, {

                if (it?.email == binding.mainEmailEdit.text.toString() && it?.password == binding.mainPasswordEdit.text.toString()) {
                    val intent = Intent(this, OfficeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_SHORT).show()
                }
            })




        }


    }
    //funcion para acceder si estamos logueados

    private fun sessionAcceso(email: String, password: String) {

        val prefs = getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE)
        val email_auth = prefs.getString("email", null)
        val password_auth = prefs.getString("password", null)

        if (email_auth == email && password_auth == password) {
            binding.authLayout.visibility = View.INVISIBLE

            val intent = Intent(this, OfficeActivity::class.java)
            startActivity(intent)
        }
    }

}