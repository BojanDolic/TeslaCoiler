package com.electrocoder.teslacoiler.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "secondaries")
data class Secondary(
    @PrimaryKey val secondaryId: Long = 0,
    val coilId: Long = 0,
    val secondaryFrequency: Float = 0f,
    @Embedded
    val topLoad: Topload
)
