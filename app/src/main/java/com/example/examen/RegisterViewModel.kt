package com.example.examen

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel

class RegisterViewModel (val registerRepository:RegisterRepository):ViewModel() {

    val model: LiveData<UiModel>
        get()=_model
    val _model =MutableLiveData<UiModel>()

    sealed class UiModel{
            class Register(val success:Boolean):UiModel()
    }
    fun doRegister(Name:String,Last:String,Email:String)
    {
        _model.value=UiModel.Register( registerRepository.register(Name,Last,Email))
    }
}