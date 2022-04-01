package com.example.artmuseumapp.rest

import com.example.artmuseumapp.model.Artworks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtAPI {

    @GET(PATH_URL)
    suspend fun getArtworks(
        @Query("hasimage") hasimage:String = "1",
        @Query("apikey") apikey:String = API_KEY
    ): Response<Artworks>

    companion object{
        const val API_KEY = "ba86fa59-4b59-4335-ba4e-d76e45edd177"
        const val BASE_URL = "https://api.harvardartmuseums.org/"
        const val PATH_URL = "exhibition"
    }

}