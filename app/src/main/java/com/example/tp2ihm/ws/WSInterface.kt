package com.example.tp2ihm.ws

import android.util.JsonReader
import com.example.tp2ihm.bo.Planet
import com.example.tp2ihm.bo.PlanetList
import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable

interface WSInterface
{
//GET
    @GET("api/planets/1")
    fun getPlanet(): Call<Planet>

    @GET("api/planets/1")
    suspend fun getPlanetSync(): Planet

    @GET("api/planets/")
    suspend fun getAllPlanets(): PlanetList


    //Don't works!!!!!!!!!!!!!!!!!!
    @GET("api/planets/{id}")
    suspend fun getOnePlanet(
        @Path("id") id: Int?) : Planet
}