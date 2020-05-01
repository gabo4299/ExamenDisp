package com.example.examen

class RegisterRepository {


    fun register(Name:String,Last:String,Email:String):Boolean {
        if (Name != "" && Last != "" && Email != "" )
        {
            return true
        }
        else {
            return  false
        }
    }
}