package com.electrocoder.teslacoiler.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.electrocoder.teslacoiler.dao.TeslaCoilDao
import com.electrocoder.teslacoiler.models.Secondary
import com.electrocoder.teslacoiler.models.TeslaCoil
import com.electrocoder.teslacoiler.models.Topload

@Database(entities = [TeslaCoil::class, Secondary::class, Topload::class], version = 1)
abstract class TeslaCoilDatabase : RoomDatabase() {

    abstract fun tcDao(): TeslaCoilDao


    companion object {

        @Volatile
        private var instance: TeslaCoilDatabase? = null

        @Synchronized
        fun getInstance(context: Context): TeslaCoilDatabase {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    TeslaCoilDatabase::class.java,
                    "tesla_coils_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!

        }


    }


}