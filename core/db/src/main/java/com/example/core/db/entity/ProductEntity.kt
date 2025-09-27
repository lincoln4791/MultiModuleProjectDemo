package com.example.core.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    val name: String,
    val generic: String,
    @PrimaryKey(autoGenerate = true) val id: Int=0,
)