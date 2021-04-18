package com.example.madassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.room_item.view.*

class RoomAdapter(private  val roomList: List<RoomItem>) : RecyclerView.Adapter<RoomAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.room_item,parent,false)

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = roomList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textview1.text = currentItem.text1
        holder.textview2.text = currentItem.text2
        holder.textview3.text = currentItem.text3

    }

    override fun getItemCount(): Int {
        if(roomList.size >2){
            return 2
        }else{
            return roomList.size
        }
    }

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.image_view
        val textview1: TextView = itemView.txtPrice
        val textview2: TextView = itemView.txtAvailable
        val textview3: TextView = itemView.txtTitle


    }

}