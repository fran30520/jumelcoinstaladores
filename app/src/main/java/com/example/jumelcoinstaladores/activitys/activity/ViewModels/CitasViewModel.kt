package com.example.jumelcoinstaladores.activitys.activity.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jumelcoinstaladores.activitys.activity.services.entities.Citas
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.AppRetrofit
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.CitasService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CitasViewModel:ViewModel() {

    private var servicio = AppRetrofit.getRetrofit().create(CitasService::class.java)

    private var TAG = "TAG_VIEW_MODEL"

    private val citas: MutableLiveData<List<Citas.Cita>> by lazy {
        MutableLiveData<List<Citas.Cita>>().also {
            cargarCitas()
        }
    }

    private fun cargarCitas(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                servicio.CitasGet().enqueue(object :Callback<List<Citas.Cita>>{
                    override fun onResponse(
                        call: Call<List<Citas.Cita>>,
                        response: Response<List<Citas.Cita>>
                    ) {
                        val body = response.body()
                        Log.d(TAG,body.toString())
                    }

                    override fun onFailure(call: Call<List<Citas.Cita>>, t: Throwable) {
                        Log.e(TAG,"Error en las Citas")
                        Log.e(TAG,t.message.toString())
                    }

                })

            }
        }

    }

    fun GetCitas(): LiveData<List<Citas.Cita>>{
        return citas
    }
}