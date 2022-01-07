package com.electrocoder.teslacoiler.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toploads")
data class Topload(
    @PrimaryKey val toploadId: Long = 0,
    val toploadCapacitance: Float = 0f
)
