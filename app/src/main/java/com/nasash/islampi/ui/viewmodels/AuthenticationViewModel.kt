package com.nasash.islampi.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasash.islampi.data.model.api.token.Authentication
import com.nasash.islampi.data.repo.AuthenticationRepo
import com.nasash.islampi.util.LogUtil
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authenticationRepo: AuthenticationRepo
) : ViewModel() {

    fun hitAuthTokenApi() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val res = authenticationRepo.hitAuthTokenApi()) {
                is NetworkResponse.Success -> {
                    LogUtil.i(res.body.toString())

                    deleteAll()

                    res.body.let {
                        saveDataInDB(it)
                    }

                }

                is NetworkResponse.ServerError -> {
                    LogUtil.e(res.code.toString())
                    LogUtil.e(res.body?.message)
                }

                is NetworkResponse.NetworkError -> {
                    res.error.printStackTrace()
                }

                is NetworkResponse.UnknownError -> {
                    res.error.printStackTrace()
                }
            }
        }
    }

    private suspend fun saveDataInDB(authentication: Authentication) {
        authenticationRepo.add(authentication)
    }


    suspend fun getAuthentication() = authenticationRepo.getAuthentication()

    suspend fun deleteAll() = authenticationRepo.deleteAll()
}