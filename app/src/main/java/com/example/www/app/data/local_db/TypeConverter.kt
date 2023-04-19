package com.example.www.app.data.local_db

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    private val gson = Gson()

    @androidx.room.TypeConverter
    fun fromStrListToJSON(list:List<String>) :String{
        return gson.toJson(list)
    }

    @androidx.room.TypeConverter
    fun fromJsonTOStringList(jsonString:String) :List<String>{
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(jsonString,type)
    }
}