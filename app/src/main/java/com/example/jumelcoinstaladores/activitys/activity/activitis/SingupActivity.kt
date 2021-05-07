package com.example.jumelcoinstaladores.activitys.activity.activitis

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.jumelcoinstaladores.R
import com.example.jumelcoinstaladores.activitys.activity.ViewModels.ClientesViewModel
import com.example.jumelcoinstaladores.databinding.ActivitySingupBinding
import com.google.android.material.textfield.TextInputEditText

class SingupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySingupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //recupero los datos introducidos en el Auth_Activity
        val bundle = intent.extras
        val email_auth = bundle?.get("email")
        val password_auth = bundle?.get("password")


        //Guardado de datos
        val prefs = getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", binding.main2EmailEdit.text.toString())
        prefs.putString("name", binding.main2NombreEdit.text.toString())
        prefs.apply()


        //Colocamos los datos recuperados en el textView para despues guardarlos todos
        binding.main2EmailEdit.setText(email_auth.toString())


        //casilla correspondiente al nombre
        binding.main2NombreEdit.setOnFocusChangeListener { _, hasFocus ->

            if (hasFocus) {
                binding.main2Nombre.error = ""
            }
        }
        binding.main2Nombre.setOnClickListener {

            val text = it as TextInputEditText

            if (text.text!!.isNotEmpty()) {
                binding.main2Nombre.error = ""
            }

        }
        //casilla correspondiente a los apellidos
        binding.main2ApellidosEdit.setOnFocusChangeListener { _, hasFocus ->

            if (hasFocus) {
                binding.main2Apellidos.error = ""
            }
        }
        binding.main2Apellidos.setOnClickListener {

            val text = it as TextInputEditText

            if (text.text!!.isNotEmpty()) {
                binding.main2Apellidos.error = ""
            }

        }
        //casilla correspondiente a la direccion
        binding.main2DirectionEdit.setOnFocusChangeListener { _, hasFocus ->

            if (hasFocus) {
                binding.main2Direction.error = ""
            }
        }
        binding.main2Direction.setOnClickListener {

            val text = it as TextInputEditText

            if (text.text!!.isNotEmpty()) {
                binding.main2Direction.error = ""
            }

        }
        //casilla correspondiente al telefono
        binding.main2PhoneEdit.setOnFocusChangeListener { _, hasFocus ->

            if (hasFocus) {
                binding.main2Phone.error = ""
            }
        }
        binding.main2Phone.setOnClickListener {

            val text = it as TextInputEditText

            if (text.text!!.isNotEmpty()) {
                binding.main2Phone.error = ""
            }

        }


        //boton registrar
        binding.main2Registrar.setOnClickListener {

            val modelCliente: ClientesViewModel by viewModels()

            val name = binding.main2NombreEdit.text
            val apellidos = binding.main2ApellidosEdit.text
            val direction = binding.main2DirectionEdit.text
            val phone = binding.main2PhoneEdit.text

            var error = false

            if (name.isNullOrEmpty()) {
                binding.main2Nombre.error = getString(R.string.main2_error_nombre)
            }
            if (apellidos.isNullOrEmpty()) {
                binding.main2Apellidos.error = getString(R.string.main2_error_apellidos)
            }
            if (direction.isNullOrEmpty()) {
                binding.main2Direction.error = getString(R.string.main2_error_direccion)
            }
            if (phone.isNullOrEmpty()) {
                binding.main2Phone.error = getString(R.string.main2_error_telefono)
            }

            if (error) {
                return@setOnClickListener
            }

            if (!name.isNullOrEmpty() && !apellidos.isNullOrEmpty() && !direction.isNullOrEmpty() && !phone.isNullOrEmpty()) {

                val prefs = getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE).edit()
                prefs.putString("name", binding.main2NombreEdit.text.toString())
                prefs.putString("apellidos", binding.main2ApellidosEdit.text.toString())
                prefs.putString("direction", binding.main2DirectionEdit.text.toString())
                prefs.putString("phone", binding.main2PhoneEdit.text.toString())
                prefs.apply()


                completar()

                Toast.makeText(this, "Registro completado", Toast.LENGTH_SHORT).show()
            }
            //Aqui ira el codigo para mandar los datos a la base de datos


        }

        //boton cancelar
        binding.main2Cancelar.setOnClickListener {

            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }

    fun TextInputEditText.obtenerTexto(): String {
        return text.toString()

    }

    fun completar() {

        val prefs = getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE)
        val email_auth = prefs.getString("email", null)
        val password_auth = prefs.getString("password", null)
        val name_auth = prefs.getString("name", null)
        val direction_auth = prefs.getString("direction", null)
        val phone_auth = prefs.getString("phone", null)


        val intent = Intent(this, AuthActivity::class.java)
        intent.putExtra("email", binding.main2EmailEdit.text.toString())
        startActivity(intent)

    }
}