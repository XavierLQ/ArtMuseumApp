package com.example.artmuseumapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artmuseumapp.R
import com.example.artmuseumapp.model.Artworks

class ArtAdapter(
    private val artList:MutableList<Artworks> = mutableListOf()
): RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    fun updateArtList(newArt:List<Artworks>){
        artList.clear()
        artList.addAll(newArt)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val jokeView = LayoutInflater.from(parent.context).inflate(R.layout.art_item, parent, false)
        return ArtViewHolder(jokeView)
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        val JokeSelect = artList[position]
        holder.bind(JokeSelect)
    }

    override fun getItemCount(): Int = artList.size


    class ArtViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        //pending define textview and imageview

        fun bind(artItem:Artworks){

            // pending add data from livedata
        }
    }
}