package com.nasash.islampi.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface AuthenticationDao {

    @Query("Select * from authentication")
    suspend fun getAuthentication(): LiveData<com.nasash.islampi.data.model.api.token.Authentication?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(authentication: com.nasash.islampi.data.model.api.token.Authentication): Long

    @Query("DELETE FROM authentication")
    suspend fun deleteAll()
}