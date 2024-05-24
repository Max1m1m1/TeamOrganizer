package com.example.ozan.teamorganizer.retrofit

import com.example.ozan.teamorganizer.db.Player
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("players")
    fun getPlayers(): Call<List<Player>>
}
