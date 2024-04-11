package com.example.music_app

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
class MyAdapter(val context: Activity, val dataList: List<Data>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Global variable to store the MediaPlayer
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = dataList[position]
        holder.title.text = currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.image);

        // Set click listeners for play and pause buttons
        holder.play.setOnClickListener {
            // If MediaPlayer is already playing, stop and release it
            mediaPlayer?.stop()
            mediaPlayer?.release()

            // Create new MediaPlayer and start playing the new song
            mediaPlayer = MediaPlayer.create(context, currentData.preview.toUri())
            mediaPlayer?.start()
        }
        holder.pause.setOnClickListener {
            // If MediaPlayer is playing, stop and release it
            mediaPlayer?.stop()
            mediaPlayer?.release()
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.musicImage)
        val title: TextView = itemView.findViewById(R.id.musicTitle)
        val play: ImageButton = itemView.findViewById(R.id.btnPlay)
        val pause: ImageButton = itemView.findViewById(R.id.btnPause)
    }
}
