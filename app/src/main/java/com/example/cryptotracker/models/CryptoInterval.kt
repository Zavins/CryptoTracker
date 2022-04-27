package com.example.cryptotracker.models

import org.json.JSONObject
import com.example.cryptotracker.utilities.JsonSafeGet

class CryptoInterval {
    var priceChange: Number = 0
    var priceChangePct: Number = 0
    var volume: Number = 0
    var volumeChange: Number? = 0
    var volumeChangePct: Number? = 0
    var marketCapChange: Number? = 0
    var marketCapChangePct: Number? = 0

    companion object{
        fun fromJson(jsonObject: JSONObject?): CryptoInterval?{
            if (jsonObject == null) return null
            val interval = CryptoInterval()
            interval.priceChange = JsonSafeGet.getDouble(jsonObject,"price_change")!!
            interval.priceChangePct = JsonSafeGet.getDouble(jsonObject,"price_change_pct")!!
            interval.volume = JsonSafeGet.getDouble(jsonObject,"volume")!!
            interval.volumeChange = JsonSafeGet.getDouble(jsonObject,"volume_change")
            interval.volumeChangePct = JsonSafeGet.getDouble(jsonObject,"volume_change_pct")
            interval.marketCapChange = JsonSafeGet.getDouble(jsonObject,"market_cap_change")
            interval.marketCapChangePct = JsonSafeGet.getDouble(jsonObject,"market_cap_change_pct")
            return interval
        }
    }
}