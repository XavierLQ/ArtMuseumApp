package com.example.artmuseumapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.artmuseumapp.R
import com.example.artmuseumapp.databinding.ArtItemBinding
import com.example.artmuseumapp.model.Artworks
import com.example.artmuseumapp.model.Record
import com.squareup.picasso.Picasso

class ArtAdapter(
    private val clickedArt: ClickedArt,
    private val artList:MutableList<Record> = mutableListOf()
): RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {



    fun updateArtList(newArt:List<Record>){
        artList.clear()
        artList.addAll(newArt)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val artView = LayoutInflater.from(parent.context).inflate(R.layout.art_item, parent, false)
        return ArtViewHolder(artView, clickedArt)
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        val artSelect = artList[position]
        holder.bind(artSelect)
    }

    override fun getItemCount(): Int = artList.size


    class ArtViewHolder(itemView: View, private val clickedArt:ClickedArt):RecyclerView.ViewHolder(itemView){
        val artName:TextView = itemView.findViewById(R.id.nameText)
        val artImage:ImageView = itemView.findViewById(R.id.imageItem)

        fun bind(artItem: Record){

            artName.text = artItem.title
            Picasso.get()
                .load(artItem.images[0].baseimageurl)
                .resize(500, 500)
                .into(artImage)

            itemView.setOnClickListener{ view ->
                view.findNavController()
                    .navigate(R.id.action_recyclerViewFragment_to_artDetailsFragment)
                clickedArt.OnClickedArt(artItem)
            }

            // pending add data from livedata
        }
    }
}