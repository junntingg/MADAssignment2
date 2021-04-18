package com.example.madassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_room_list.*

class roomList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_list)
        val roomList = generateDummyList(500)
        recycler_view.adapter = RoomAdapter(roomList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }
    private fun generateDummyList(size: Int): List<RoomItem> {
        val list = ArrayList<RoomItem>()
        for (i in 0 until size) {
            val textTitle = when (i % 3) {
                0 -> "REGULAR"
                1 -> "EXECUTE"
                else -> "null"
            }
            val drawable = when (i % 3) {
                0 -> R.drawable.superiorone
                1 -> R.drawable.execute
                else -> R.drawable.ic_baseline_wb_sunny_24
            }
            val textPrice = when (i % 3) {
                0 -> "Price:RM99"
                1 -> "Price:RM199"
                else -> "null"
            }
            val textAvailable = when (i % 3) {
                0 -> "Available:100"
                1 -> "Available:100"
                else -> "null"
            }
            val item = RoomItem(drawable, textPrice, textAvailable,textTitle
            )
            list += item
        }
        return list
    }
    fun sendMessage(view: View){
        val intent = Intent(this, serviceList::class.java)

        startActivity(intent)
    }

}