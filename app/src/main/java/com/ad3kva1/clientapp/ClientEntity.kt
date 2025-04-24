package com.ad3kva1.clientapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients")
data class ClientEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val visits: Int,
    val date: String,
    val notes: String,
    val homework: String,
    val isArchived: Boolean = false
)