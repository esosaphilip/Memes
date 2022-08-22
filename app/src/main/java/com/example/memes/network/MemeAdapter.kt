package com.example.memes.network

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memes.R
import com.example.memes.model.MemeX


class MemeAdapter(private var context: Context, private val memes: List<MemeX> ): RecyclerView.Adapter<MemeAdapter.MemeViewHolder>() {


    class MemeViewHolder( private val memeView: View):RecyclerView.ViewHolder(memeView){

       val nam: TextView =memeView.findViewById(R.id.name)
       val image: ImageView = memeView.findViewById(R.id.img)
        val boxC : TextView = memeView.findViewById(R.id.b_count)
       val hei : TextView = memeView.findViewById(R.id.height)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.memes_item,parent, false)
        return MemeViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        val toast = memes[position]
        holder.nam.text = toast.name
        holder.boxC.text = toast.box_count.toString()
        holder.hei.text = toast.height.toString()

        //image.load(url)

        Glide.with(context).load(toast.url).into(holder.image)

    }

    override fun getItemCount(): Int = memes.size
}