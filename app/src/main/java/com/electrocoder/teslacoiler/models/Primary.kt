package com.electrocoder.teslacoiler.models

import androidx.room.Embedded
import androidx.room.Entity

data class Primary(
    val id: Long = 0,
    val frequency: Float = 0f,
    val numberOfTurns: Int = 0,
    @Embedded
    val tankCapacitor: Capacitor,
)