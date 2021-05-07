package com.example.jumelcoinstaladores.activitys.activity.services.entities

import java.util.*

sealed class Citas {
    data class Cita(val id: Int, val idCli: Int, val fecha: Date, val observaciones: String)
    data class CitaGet(val idCli: Int)
}