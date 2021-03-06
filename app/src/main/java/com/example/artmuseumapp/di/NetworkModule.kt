package com.example.artmuseumapp.di

import com.example.artmuseumapp.rest.ArtAPI
import com.example.artmuseumapp.rest.ArtRepoImplementation
import com.example.artmuseumapp.rest.ArtRepository
import com.example.artmuseumapp.viewmodel.ArtViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



val NetworkModule = module{

    fun providesGson(): Gson = Gson()

    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    fun providesNetworkService(gson: Gson, okHttpClient: OkHttpClient): ArtAPI =
        Retrofit.Builder().baseUrl(ArtAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient).build()
            .create(ArtAPI::class.java)

    fun provideArtRepository(artAPI: ArtAPI):ArtRepository =
        ArtRepoImplementation(artAPI)

    single { providesLoggingInterceptor()}
    single { providesOkHttpClient(get()) }
    single { providesNetworkService(get(), get()) }
    single { provideArtRepository(get()) }
    single { providesGson() }

}

val viewModelModule = module{

    viewModel { ArtViewModel(get())}
}