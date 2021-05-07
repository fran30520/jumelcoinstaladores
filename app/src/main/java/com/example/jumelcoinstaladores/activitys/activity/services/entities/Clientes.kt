package com.example.jumelcoinstaladores.activitys.activity.services


sealed class Clientes {

    data class Cliente(val id: Int, val nombre: String, val direccion: String, val telefono: Int, val email: String, val contrasena: String)
    data class ClienteGet(val id: Int)
    data class ClienteUpdate(val nombre: String)
    data class ClienteLogin(val email: String, val password: String)
}