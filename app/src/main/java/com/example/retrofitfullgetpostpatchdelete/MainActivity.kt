package com.example.retrofitfullgetpostpatchdelete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitfullgetpostpatchdelete.model.User
import com.example.retrofitfullgetpostpatchdelete.model.UserList
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), OnItemClick {
    lateinit var mAdapter: UserAdapters
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()
        initViewModel()
        searchUser()

        img_add_user.setOnClickListener{
            startActivity(Intent(this, CreateUserActivity::class.java))
        }
    }

    private fun initRecyclerView() {
        rcy_user.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            mAdapter = UserAdapters(this@MainActivity)
            adapter = mAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getUserListObservable().observe(this, Observer<UserList> {
            if (it == null) {
                Toast.makeText(this, "data empty", Toast.LENGTH_SHORT).show()
            } else {
                mAdapter.userList = it.data.toMutableList()
                mAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getUserList()
    }

    private fun searchUser() {
        img_search.setOnClickListener {
            if (!TextUtils.isEmpty(edt_search.text.toString())){
                viewModel.searchUser(edt_search.text.toString())
            } else {
               viewModel.getUserList()
            }
        }
    }

    override fun onItemClick(user: User) {
        val intent = Intent(this, CreateUserActivity::class.java)
        intent.putExtra("user_id", user.id)
        startActivityForResult(intent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1000) {
            viewModel.getUserList()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}