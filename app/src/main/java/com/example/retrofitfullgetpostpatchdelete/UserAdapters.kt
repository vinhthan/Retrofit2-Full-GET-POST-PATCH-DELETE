package com.example.retrofitfullgetpostpatchdelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitfullgetpostpatchdelete.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapters(val clickItem: OnItemClick): RecyclerView.Adapter<UserAdapters.UserViewHolder>() {
    var userList = mutableListOf<User>()

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.itemView.setOnClickListener {
            clickItem.onItemClick(userList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var tvName: TextView = view.tv_name
        private var tvEmail: TextView = view.tv_email
        fun bind(data: User) {
            tvName.text = data.name
            tvEmail.text = data.email
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }



}
interface OnItemClick{
    fun onItemClick(user : User)
}