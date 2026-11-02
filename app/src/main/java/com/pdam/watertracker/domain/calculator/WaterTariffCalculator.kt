package com.pdam.watertracker.domain.calculator

data class Tier(val minConsumption: Double, val maxConsumption: Double?, val ratePerM3: Long)

object WaterTariffCalculator {
    val DEFAULT_R2_TIERS = listOf(
        Tier(0.0, 10.0, 2400L),
        Tier(10.0, 20.0, 3600L),
        Tier(20.0, 30.0, 5000L),
        Tier(30.0, null, 7200L)
    )

    fun calculateConsumption(
        previousMeter: Double,
        currentMeter: Double,
        isMeterReplaced: Boolean = false,
        oldMeterFinal: Double = 0.0,
        newMeterInitial: Double = 0.0
    ): Pair<Double, String?> {
        if (isMeterReplaced) {
            val consumed = (oldMeterFinal - previousMeter) + (currentMeter - newMeterInitial)
            return Pair(consumed, null)
        }
        if (currentMeter < previousMeter) {
            return Pair(0.0, "Meter terbaru lebih kecil dari meter sebelumnya")
        }
        return Pair(currentMeter - previousMeter, null)
    }
}
