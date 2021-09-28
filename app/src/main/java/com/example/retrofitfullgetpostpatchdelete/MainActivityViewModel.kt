package com.example.retrofitfullgetpostpatchdelete

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitfullgetpostpatchdelete.model.UserList
import com.example.retrofitfullgetpostpatchdelete.network.RetrofitInstance
import com.example.retrofitfullgetpostpatchdelete.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivityViewModel : ViewModel() {

    var userList: MutableLiveData<UserList> = MutableLiveData()

    fun getUserListObservable(): MutableLiveData<UserList> {
        return userList
    }

    fun getUserList() {
        val retrofitService = RetrofitInstance.getRetrofit().create(RetrofitService::class.java)
        val call = retrofitService.getUsersList()
        call.enqueue(object : Callback<UserList> {
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if (response.isSuccessful) {
                    userList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                //userList.postValue(null)
            }
        })
    }

    fun searchUser(searchText: String) {
        val retrofitService = RetrofitInstance.getRetrofit().create(RetrofitService::class.java)
        val call = retrofitService.searchUsers(searchText.toLowerCase())
        call.enqueue(object : Callback<UserList> {
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if (response.isSuccessful) {
                    userList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                //userList.postValue(null)
            }
        })
    }

}