package com.ad3kva1.clientapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ClientEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
}