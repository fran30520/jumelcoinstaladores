package com.example.jumelcoinstaladores.activitys.activity.services.repositories

import com.example.jumelcoinstaladores.activitys.activity.services.entities.Citas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CitasService {

    @GET("/citas")
    fun CitasGet(): Call<List<Citas.Cita>>

    @GET("/citas/{idCli}")
    fun CitaGet(@Path("idCli") id:Int):Call<Citas.CitaGet>
}