package com.example.jumelcoinstaladores.activitys.activity.services.entities


sealed class Servicio {

    data class servicio(val id: Int, val nombre: String, val tipo: String)
    data class servicioGet(val id: Int)
}