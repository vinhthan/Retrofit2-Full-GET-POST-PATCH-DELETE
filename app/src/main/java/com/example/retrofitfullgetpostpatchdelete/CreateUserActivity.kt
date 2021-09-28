package com.example.retrofitfullgetpostpatchdelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitfullgetpostpatchdelete.model.User
import com.example.retrofitfullgetpostpatchdelete.model.UserResponse
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {
    lateinit var viewModel: CreateUserActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        var userId = intent.getStringExtra("user_id")

        initViewModel()
        createUserObservable()

        if (userId != null) {
            loadUserData(userId)
        }

        btn_create_user.setOnClickListener {
            createUser(userId)
        }

        btn_delete_user.setOnClickListener {
            deleteUser(userId)
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[CreateUserActivityViewModel::class.java]
    }

    private fun createUserObservable() {
        viewModel.getCreateNewUserObservable().observe(this, Observer <UserResponse?>{
            if(it == null) {
                Toast.makeText(this, "Failed to create/update new user...", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Successfully created/updated user...", Toast.LENGTH_LONG).show()
                finish()
            }
        })
    }

    private fun createUser(userId: String?) {
        val user = User("", edt_create_name.text.toString(), edt_create_email.text.toString(), "Active", "Male")
        if (userId == null) {
            viewModel.createUser(user)
        } else {
            viewModel.updateUser(userId, user)
        }
    }

    private fun loadUserData(userId: String?) {
        viewModel.getLoadUserObservable().observe(this, Observer <UserResponse?>{
            if(it != null) {
                edt_create_name.setText(it.data?.name)
                edt_create_email.setText(it.data?.email)
                btn_create_user.text = "Update"
            }
        })
        viewModel.getUserData(userId!!)
    }

    private fun deleteUser(id: String?) {
        viewModel.getDeleteUserObservable().observe(this, Observer <UserResponse?>{
            if(it == null) {
                Toast.makeText(this, "Failed to delete new user...", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Successfully delete user...", Toast.LENGTH_LONG).show()
                finish()
            }
        })
        viewModel.deleteUser(id)
    }
}