package com.example.jumelcoinstaladores.activitys.activity.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jumelcoinstaladores.activitys.activity.services.Clientes
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.AppRetrofit
import com.example.jumelcoinstaladores.activitys.activity.services.repositories.AuthService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class authViewModel : ViewModel() {

    private var servicio = AppRetrofit.getRetrofit().create(AuthService::class.java)

    private var TAG = "TAG_VIEW_MODEL"

     fun cargarLogin(login:Clientes.ClienteLogin): LiveData<Clientes.ClienteLogin?> {

         val LiveData = MutableLiveData<Clientes.ClienteLogin?>()

         viewModelScope.launch {
             withContext(Dispatchers.IO) {
                 servicio.login(login).enqueue(object : Callback<Clientes.ClienteLogin> {
                     override fun onResponse(
                         call: Call<Clientes.ClienteLogin>,
                         response: Response<Clientes.ClienteLogin>
                     ) {
                         val body = response.body()
                         if (body != null) {
                             Log.d(TAG, body.toString())
                             LiveData.postValue(body!!)

                         }

                     }

                     override fun onFailure(call: Call<Clientes.ClienteLogin>, t: Throwable) {
                         Log.e(TAG, "Cliente no registrado")
                         Log.e(TAG, t.message!!)
                         LiveData.postValue(null)

                     }

                 })


             }
         }
         return LiveData
     }
}