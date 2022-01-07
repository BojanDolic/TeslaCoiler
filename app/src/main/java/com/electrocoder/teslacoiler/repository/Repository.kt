package com.electrocoder.teslacoiler.repository

import com.electrocoder.teslacoiler.dao.TeslaCoilDao
import com.electrocoder.teslacoiler.models.TeslaCoil
import javax.inject.Inject

class Repository @Inject constructor(
    val dao: TeslaCoilDao
) {

    suspend fun getTeslaCoil(id: Long): TeslaCoil {
        return dao.getTeslaCoil(id)
    }













}