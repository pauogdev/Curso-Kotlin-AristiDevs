package com.pauortegarcia.cursokotlin.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/827304222151917/search/{name}")
    suspend fun getSuperHeroes(@Path("name") name: String): Response<SuperHeroDataResponse>


}