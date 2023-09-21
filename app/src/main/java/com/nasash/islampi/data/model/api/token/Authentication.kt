package com.nasash.islampi.data.model.api.token

import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
class Authentication (
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null,

    @SerializedName("token_type")
    @Expose
    var tokenType: String? = null,

    @SerializedName("expires_in")
    @Expose
    var expiresIn: Int? = null,

    @SerializedName("refresh_token")
    @Expose
    var refreshToken: String? = null,

    @SerializedName(".issued")
    @Expose
    var issued: String? = null,

    @SerializedName(".expires")
    @Expose
    var expires: String? = null,

    @SerializedName("error")
    @Expose
    var error: String? = null,

    @SerializedName("error_description")
    @Expose
    var error_description: String? = null,

    @SerializedName("longpoll")
    @Expose
    var longpoll: String? = null,
)