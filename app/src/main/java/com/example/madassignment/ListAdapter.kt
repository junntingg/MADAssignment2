package com.example.madassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madassignment.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.tvStaffId.text = currentItem.staffId.toString()
        holder.itemView.tvName.text = currentItem.name
        holder.itemView.tvIcNo.text = currentItem.icNo
        holder.itemView.tvPassword.text = currentItem.password
        holder.itemView.tvAddress.text = currentItem.address
        holder.itemView.tvEmail.text = currentItem.email
        holder.itemView.tvPhoneNo.text = currentItem.phoneNo
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}