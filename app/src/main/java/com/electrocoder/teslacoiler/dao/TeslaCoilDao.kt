package com.electrocoder.teslacoiler.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.electrocoder.teslacoiler.models.TeslaCoil

@Dao
interface TeslaCoilDao {

    @Transaction
    @Query("SELECT * FROM tesla_coils WHERE id IN (:coilId)")
    suspend fun getTeslaCoil(coilId: Long): TeslaCoil

}