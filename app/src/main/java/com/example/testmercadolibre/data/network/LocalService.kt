package com.example.testmercadolibre.data.network

import android.content.Context
import com.example.testmercadolibre.data.model.ComponetsJSONDTO
import com.example.testmercadolibre.utils.readJsonFromAssets
import com.google.gson.Gson
import java.io.IOException

class LocalService(private val context: Context) {

    fun getHome(): ComponetsJSONDTO? {
        return try {
            val jsonString = readJsonFromAssets(context, "home.json")
            if (jsonString != null) {
                Gson().fromJson(jsonString, ComponetsJSONDTO::class.java)
            } else {
                null
            }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}