package com.example.jumelcoinstaladores.activitys.activity.services.repositories

import com.example.jumelcoinstaladores.activitys.activity.services.Clientes
import retrofit2.Call
import retrofit2.http.*

interface ClientesService {

    @GET("/clientes")
    fun getClientes(): Call<List<Clientes.Cliente>>

    @GET("/clientes/{id}")
    fun getCliente(@Path("id") id: Int): Call<Clientes.ClienteGet>

    @PUT("/clientes/{id}")
    fun updateCliente(@Path("id") id: Int,@Body clientes: Clientes.ClienteUpdate): Call<Clientes.ClienteGet>

    @POST("/clientes")
    fun postCliente(@Body Cliente:Clientes.Cliente):Call<Clientes.Cliente>
}