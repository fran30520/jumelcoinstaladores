package com.example.jumelcoinstaladores.activitys.activity.services.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppRetrofit {

    companion object {

        private var _retrofit: Retrofit? = null
        fun getRetrofit(): Retrofit {
            if (_retrofit == null) {
                _retrofit = Retrofit.Builder().baseUrl("http://192.168.18.4:3200/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return _retrofit!!
        }

    }
}