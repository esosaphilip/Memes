package com.example.memes.network

import com.example.memes.model.Meme
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private  const val  BASE_URL = "https://api.imgflip.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MemeInterface {
    @GET("/get_memes")
    fun getLaughs(): Call<Meme>

}

object MemeInstance{
    val retrofitService: MemeInterface by lazy{
        retrofit.create(MemeInterface::class.java)
    }
}







