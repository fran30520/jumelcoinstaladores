package com.example.jumelcoinstaladores.activitys.activity.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jumelcoinstaladores.activitys.activity.services.entities.Servicio
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.AppRetrofit
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.ServiciosService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiciosViewModel : ViewModel() {

    private var service = AppRetrofit.getRetrofit().create(ServiciosService::class.java)
    private var TAG = "TAG_VIEW_MODEL"

    private val servicio: MutableLiveData<List<Servicio.servicio>> by lazy {
        MutableLiveData<List<Servicio.servicio>>().also {
            cargarServicios()
        }
    }

    private fun cargarServicios() {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                service.getServicios().enqueue(object : Callback<List<Servicio.servicio>> {
                    override fun onResponse(call: Call<List<Servicio.servicio>>, response: Response<List<Servicio.servicio>>) {
                        val body = response.body()
                        Log.d(TAG, body.toString())
                    }

                    override fun onFailure(call: Call<List<Servicio.servicio>>, t: Throwable) {
                        Log.e(TAG, "Error al cargar los servicios")
                        Log.e(TAG, t.message.toString())
                    }

                })
            }
        }

    }

    fun getServicio(): LiveData<List<Servicio.servicio>>{
        return servicio
    }
}