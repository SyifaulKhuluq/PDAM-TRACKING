package com.pdam.watertracker.data.dao

import androidx.room.*
import com.pdam.watertracker.data.entity.MeterReadingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MeterReadingDao {
    @Query("SELECT * FROM meter_readings ORDER BY periodYear DESC, periodMonth DESC")
    fun getAllReadings(): Flow<List<MeterReadingEntity>>

    @Query("SELECT * FROM meter_readings ORDER BY periodYear DESC, periodMonth DESC LIMIT 1")
    suspend fun getLatestReading(): MeterReadingEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReading(reading: MeterReadingEntity): Long

    @Update
    suspend fun updateReading(reading: MeterReadingEntity)

    @Delete
    suspend fun deleteReading(reading: MeterReadingEntity)
}
