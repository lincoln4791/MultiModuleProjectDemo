package com.example.core.network.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object GsonUtils {

    val gson = Gson()
    @Suppress("UNCHECKED_CAST")
    fun <T> convertToList(any: Any, clazz: Class<T>): List<T> {
        val json = gson.toJson(any)  // turn Any into JSON string
        val type = TypeToken.getParameterized(List::class.java, clazz).type
        return gson.fromJson(json, type)
    }


    @Suppress("UNCHECKED_CAST")
    fun <T> convertToObject(any: Any, clazz: Class<T>): T {
        val json = gson.toJson(any)  // turn Any into JSON string
        return gson.fromJson(json, clazz)
    }

}