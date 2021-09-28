package com.example.retrofitfullgetpostpatchdelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitfullgetpostpatchdelete.model.User

class UserAdapter: PagingDataAdapter<User, UserAdapter.UserViewHolder>(DiffCallBack()) {
    lateinit var userList: List<User>

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tv_name)
        var tvEmail: TextView = view.findViewById(R.id.tv_email)
        fun bind(data: User) {
            tvName.text = data.name
            tvEmail.text = data.email
        }
    }

    class DiffCallBack: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return when {
                oldItem.id != newItem.id -> {
                    false
                }
                oldItem.name != newItem.name -> {
                    false
                }
                oldItem.email != newItem.email -> {
                    false
                }

                else -> true
            }
        }

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

}