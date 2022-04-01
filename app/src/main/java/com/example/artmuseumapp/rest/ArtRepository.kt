package com.example.artmuseumapp.rest

import com.example.artmuseumapp.model.Artworks
import retrofit2.Response

interface ArtRepository {
    suspend fun getArtworks(): Response<Artworks>
}

class ArtRepoImplementation(private val artAPI: ArtAPI): ArtRepository{
    override suspend fun getArtworks(): Response<Artworks> = artAPI.getArtworks()
}