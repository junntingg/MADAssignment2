package com.example.madassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_room_list.*

class serviceList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_list)

        val serviceList = generateDummyList(500)
        recycler_view.adapter = ServiceAdapter(serviceList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }
    private fun generateDummyList(size: Int): List<ServiceItem> {
        val list = ArrayList<ServiceItem>()
        for (i in 0 until size) {
            val textTitle = when (i % 3) {
                0 -> "SPA"
                1 -> "BUFFET"
                else -> "null"
            }
            val drawable = when (i % 3) {
                0 -> R.drawable.spa
                1 -> R.drawable.buffet
                else -> R.drawable.ic_baseline_wb_sunny_24
            }
            val textPrice = when (i % 3) {
                0 -> "Price:RM299"
                1 -> "Price:RM99"
                else -> "null"
            }
            val textAvailable = when (i % 3) {
                0 -> "Available:100"
                1 -> "Available:100"
                else -> "null"
            }
            val item = ServiceItem(drawable, textPrice, textAvailable,textTitle
            )
            list += item
        }
        return list
    }
    fun sendButton(view: View){
        val intent = Intent(this, MainLogin::class.java)

        startActivity(intent)
    }
}