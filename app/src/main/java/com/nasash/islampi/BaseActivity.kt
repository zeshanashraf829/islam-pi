package com.nasash.islampi

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nasash.islampi.util.PreferenceUtil
import com.google.gson.Gson
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    protected val authenticationViewModel: com.nasash.islampi.ui.viewmodels.AuthenticationViewModel by viewModels()

    @Inject
    lateinit var preferenceUtil: PreferenceUtil

    @Inject
    lateinit var gson: Gson

}