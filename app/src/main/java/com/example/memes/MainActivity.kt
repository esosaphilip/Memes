package com.example.memes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.util.Log.e
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.LinearLayoutManager

import com.example.memes.databinding.ActivityMainBinding
import com.example.memes.model.Meme
import com.example.memes.network.MemeAdapter
import com.example.memes.network.MemeInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       // d("chess", ""+response.body())
        //e("mess","enter data is error fetching")



        val client = MemeInstance.retrofitService.getLaughs()
        client.enqueue(object:Callback<Meme>{
            override fun onResponse(call: Call<Meme>, response: Response<Meme>) {
                d("chess", ""+response.body())
                val body = response.body()
                val manner = body?.data
                binding.recyclerV.apply{
                    if (manner != null) {
                        adapter = MemeAdapter(this@MainActivity, manner.memes )
                    }
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }

            }

            override fun onFailure(call: Call<Meme>, t: Throwable) {

                e("mess","enter data is error fetching")

            }


        })




    }



}

