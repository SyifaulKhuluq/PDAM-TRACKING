package com.pdam.watertracker.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "meter_readings",
    indices = [Index(value = ["periodYear", "periodMonth"], unique = true)]
)
data class MeterReadingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val periodYear: Int,
    val periodMonth: Int,
    val readingDate: String,
    val previousMeterValue: Double,
    val currentMeterValue: Double,
    val consumptionM3: Double,
    val isMeterReplaced: Boolean = false,
    val replacementOldMeterFinalValue: Double? = null,
    val replacementNewMeterInitialValue: Double? = null,
    val tariffMethod: String = "progressive",
    val estimatedBill: Long,
    val actualBill: Long? = null,
    val administrativeFee: Long = 5000L,
    val serviceFee: Long = 3500L,
    val meterRentFee: Long = 2500L,
    val wasteFee: Long = 2000L,
    val taxFee: Long = 0L,
    val note: String = "",
    val photoUri: String? = null,
    val status: String = "estimated",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
