package com.example.registerv2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_Person")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val firstName: String,
    val surname: String
)