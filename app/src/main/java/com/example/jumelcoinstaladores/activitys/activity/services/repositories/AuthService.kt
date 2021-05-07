package com.example.jumelcoinstaladores.activitys.activity.services.repositories

import com.example.jumelcoinstaladores.activitys.activity.services.Clientes
import retrofit2.Call
import retrofit2.http.POST

interface AuthService {

    @POST("/login")
    fun login(login: Clientes.ClienteLogin):Call<Clientes.ClienteLogin>
}