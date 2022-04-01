package com.example.artmuseumapp

import android.app.Application
import dagger.Component
//
@Component
interface ApplicationComponent{}

class ArtApp:Application(){
    val appComponent : ApplicationComponent =
        DaggerApplicationComponent.create()
}