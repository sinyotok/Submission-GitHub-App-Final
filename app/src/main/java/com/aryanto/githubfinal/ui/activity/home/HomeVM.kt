package com.aryanto.githubfinal.ui.activity.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aryanto.githubfinal.data.model.Item
import com.aryanto.githubfinal.data.remote.network.ApiService
import com.aryanto.githubfinal.utils.ClientState
import kotlinx.coroutines.launch

class HomeVM(
    private val apiService: ApiService
) : ViewModel() {

    private val _users = MutableLiveData<ClientState<List<Item>>>()
    val users: LiveData<ClientState<List<Item>>> = _users

    fun getAllUsers() {
        viewModelScope.launch {
            _users.postValue(ClientState.Loading)

            try {
                val response = apiService.getAllUser()

                if (response.isEmpty()) {
                    throw IllegalAccessException()
                } else {
                    _users.postValue(ClientState.Success(response))
                }
            } catch (e: Exception) {
                val errorMSG = "${e.message}"
                Log.e("GAF-HVM", errorMSG, e)
                _users.postValue(ClientState.Error(errorMSG))
            }
        }
    }

}