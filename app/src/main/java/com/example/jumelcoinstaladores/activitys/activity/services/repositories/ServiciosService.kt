package com.example.jumelcoinstaladores.activitys.activity.services.repositories

import com.example.jumelcoinstaladores.activitys.activity.services.entities.Servicio
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiciosService {

    @GET("/servicios")
    fun getServicios(): Call<List<Servicio.servicio>>

    @GET("/servicios/{id}")
    fun getServicio(@Path("id") id: Int): Call<List<Servicio.servicio>>

    @POST("servicios")
    fun postServicio():Call<Servicio.servicio>
}