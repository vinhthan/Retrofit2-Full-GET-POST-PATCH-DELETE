package com.example.retrofitfullgetpostpatchdelete

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitfullgetpostpatchdelete.model.User
import com.example.retrofitfullgetpostpatchdelete.model.UserResponse
import com.example.retrofitfullgetpostpatchdelete.network.RetrofitInstance
import com.example.retrofitfullgetpostpatchdelete.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateUserActivityViewModel: ViewModel() {

    var createNewUser: MutableLiveData<UserResponse?> = MutableLiveData()
    var loadUserData: MutableLiveData<UserResponse?> = MutableLiveData()
    var deleteUserData: MutableLiveData<UserResponse?> = MutableLiveData()

    fun getCreateNewUserObservable() : MutableLiveData<UserResponse?> {
        return createNewUser
    }

    fun getLoadUserObservable() : MutableLiveData<UserResponse?> {
        return loadUserData
    }

    fun getDeleteUserObservable() : MutableLiveData<UserResponse?> {
        return deleteUserData
    }

    fun createUser(user: User) {
        val retroService = RetrofitInstance.getRetrofit().create(RetrofitService::class.java)
        val call = retroService.createUser(user)
        call.enqueue(object : Callback<UserResponse?> {
            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                createNewUser.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful) {
                    createNewUser.postValue(response.body())
                } else {
                    createNewUser.postValue(null)
                }
            }
        })
    }

    fun getUserData(id: String) {
        val retroService = RetrofitInstance.getRetrofit().create(RetrofitService::class.java)
        val call = retroService.getUser(id)
        call.enqueue(object : Callback<UserResponse?> {
            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                loadUserData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful) {
                    loadUserData.postValue(response.body())
                } else {
                    loadUserData.postValue(null)
                }
            }
        })
    }

    fun updateUser(id: String, user: User) {
        val retroService = RetrofitInstance.getRetrofit().create(RetrofitService::class.java)
        val call = retroService.updateUser(id, user)
        call.enqueue(object : Callback<UserResponse?> {
            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                createNewUser.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful) {
                    createNewUser.postValue(response.body())
                } else {
                    createNewUser.postValue(null)
                }
            }
        })
    }

    fun deleteUser(id: String?) {
        val retroService = RetrofitInstance.getRetrofit().create(RetrofitService::class.java)
        val call = retroService.deleteUser(id!!)
        call.enqueue(object : Callback<UserResponse?> {
            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                deleteUserData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful) {
                    deleteUserData.postValue(response.body())
                } else {
                    deleteUserData.postValue(null)
                }
            }
        })
    }

}