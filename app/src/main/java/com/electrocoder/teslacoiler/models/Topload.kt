package com.electrocoder.teslacoiler.models

import androidx.room.Entity

@Entity(tableName = "toploads")
data class Topload(
    val capacitance: Float = 0f
)
