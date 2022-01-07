package com.electrocoder.teslacoiler.models

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "secondaries")
data class Secondary(
    val frequency: Float = 0f,
    @Embedded
    val topLoad: Topload
)
