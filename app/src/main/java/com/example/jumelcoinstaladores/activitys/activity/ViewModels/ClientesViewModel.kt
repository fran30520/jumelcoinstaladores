package com.example.jumelcoinstaladores.activitys.activity.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jumelcoinstaladores.activitys.activity.services.Clientes
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.AppRetrofit
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.ClientesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientesViewModel : ViewModel() {

    private val service = AppRetrofit.getRetrofit().create(ClientesService::class.java)
    private val TAG = "CLIENTES_VIEW_MODEL"

    private val clientes: MutableLiveData<List<Clientes.Cliente>> by lazy {
        MutableLiveData<List<Clientes.Cliente>>().also {
            cargarClientes()
        }
    }


    private fun cargarClientes() {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                service.getClientes().enqueue(object : Callback<List<Clientes.Cliente>> {
                    override fun onResponse(
                        call: Call<List<Clientes.Cliente>>,
                        response: Response<List<Clientes.Cliente>>
                    ) {
                        val body = response.body()
                        Log.d(TAG, body.toString())
                    }

                    override fun onFailure(call: Call<List<Clientes.Cliente>>, t: Throwable) {
                        Log.e(TAG, "Error de conexion")
                        Log.e(TAG, t.message!!)
                        t.printStackTrace()
                    }

                })
            }
        }
    }

    private fun crearCliente(cliente:Clientes.Cliente): LiveData<Clientes.Cliente?> {

        val LiveData = MutableLiveData<Clientes.Cliente?>()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                service.postCliente(cliente).enqueue(object : Callback<Clientes.Cliente>{
                    override fun onResponse(
                        call: Call<Clientes.Cliente>,
                        response: Response<Clientes.Cliente>
                    ) {
                        val body = response.body()
                        Log.d(TAG,body.toString())
                        LiveData.postValue(body!!)
                    }

                    override fun onFailure(call: Call<Clientes.Cliente>, t: Throwable) {
                        Log.e(TAG, "Cliente no creado")
                        Log.e(TAG, t.message!!)
                        LiveData.postValue(null)
                    }

                })
            }
        }
        return LiveData
    }

    fun getClientes(): LiveData<List<Clientes.Cliente>> {
        return clientes
    }


}