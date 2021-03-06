package com.example.artmuseumapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artmuseumapp.model.Record
import com.example.artmuseumapp.rest.ArtRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtViewModel(
    private val artRepo:ArtRepository
): ViewModel() {

    private val _artLiveData:MutableLiveData<ArtLoadingState> =
        MutableLiveData(ArtLoadingState.LOADING)
    val artLiveData:LiveData<ArtLoadingState> get() = _artLiveData
    var fragmentDetail:MutableLiveData<Record> = MutableLiveData()

    fun getArtCollection() {
            viewModelScope.launch(Dispatchers.IO) {
            try {

                val response = artRepo.getArtworks()
                if(response.isSuccessful){
                    response.body()?.let{
                        _artLiveData.postValue(ArtLoadingState.SUCCESS(it))
                    }?: throw Exception("Response was null")
                } else{ throw Exception("Response was unsuccessful")}
            }
            catch(e: Exception){
                _artLiveData.postValue(ArtLoadingState.ERROR(e))
            }
        }
    }

    fun getFragmentDetail(record:Record){
        fragmentDetail = MutableLiveData(record)
    }




}