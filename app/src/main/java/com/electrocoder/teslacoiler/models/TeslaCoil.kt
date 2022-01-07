package com.electrocoder.teslacoiler.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.io.Serializable

@Entity(tableName = "tesla_coils")
data class TeslaCoil(
    @PrimaryKey
    val id: Long = 0,
    val name: String = "",
    val finished: Boolean = false,
    @Embedded
    val primary: Primary,

    //val secondary: Secondary,


    ) : Serializable