package com.example.registerv2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonDao {
    @Query("SELECT * FROM t_Person")
    fun getAllPeople(): LiveData<List<Person>>

    @Query("SELECT COUNT(*) FROM t_Person")
    fun getNumPeople(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("DELETE FROM t_Person")
    suspend fun deleteAll()
}