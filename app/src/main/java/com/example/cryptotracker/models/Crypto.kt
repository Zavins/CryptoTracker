package com.example.cryptotracker.models

import org.json.JSONArray
import org.json.JSONObject
import com.example.cryptotracker.utilities.JsonSafeGet

class Crypto {
    var id: String = ""
    var currency: String = ""
    var name:String = ""
    var status: String = ""
    var rank: Number = 0
    var price: Number = 0
    var priceTimestamp: String = ""
    var high: Number = 0
    var highTimestamp: String = ""
    var circulatingSupply: Number? = 0
    var maxSupply: Number? = 0
    var marketCap: Number? = 0
    var numExchanges: Number? = 0
    var numPairs: Number? = 0
    var numParisUnmapped: Number? = 0
    var firstTrade: String? = ""
    var logoURL: String? = ""
    var oneHour: CryptoInterval? = null
    var oneDay: CryptoInterval? = null
    var sevenDay: CryptoInterval? = null
    var thirtyDay: CryptoInterval? = null
    var oneYear: CryptoInterval? = null
    var ytd: CryptoInterval? = null

    companion object{
        fun fromJson(jsonObject: JSONObject): Crypto{
            val crypto = Crypto()
            crypto.id = JsonSafeGet.getString(jsonObject,"id")!!
            crypto.currency = JsonSafeGet.getString(jsonObject,"currency")!!
            crypto.name = JsonSafeGet.getString(jsonObject,"name")!!
            crypto.status = JsonSafeGet.getString(jsonObject,"status")!!
            crypto.rank = JsonSafeGet.getInt(jsonObject,"rank")!!
            crypto.price = JsonSafeGet.getDouble(jsonObject,"price")!!
            crypto.priceTimestamp = JsonSafeGet.getString(jsonObject,"price_timestamp")!!
            crypto.high = JsonSafeGet.getDouble(jsonObject,"high")!!
            crypto.highTimestamp = JsonSafeGet.getString(jsonObject,"high_timestamp")!!
            crypto.circulatingSupply = JsonSafeGet.getInt(jsonObject,"circulating_supply")
            crypto.maxSupply = JsonSafeGet.getInt(jsonObject,"max_supply")
            crypto.marketCap = JsonSafeGet.getDouble(jsonObject,"market_cap")
            crypto.numExchanges = JsonSafeGet.getInt(jsonObject,"num_exchanges")
            crypto.numPairs = JsonSafeGet.getInt(jsonObject,"num_pairs")
            crypto.numParisUnmapped = JsonSafeGet.getInt(jsonObject,"num_pairs_unmapped")
            crypto.firstTrade = JsonSafeGet.getString(jsonObject, "first_trade")
            crypto.logoURL = JsonSafeGet.getString(jsonObject,"logo_url")
            crypto.oneHour = CryptoInterval.fromJson(JsonSafeGet.getJSONObject(jsonObject,"1h"))
            crypto.oneDay = CryptoInterval.fromJson(JsonSafeGet.getJSONObject(jsonObject,"1d"))
            crypto.sevenDay = CryptoInterval.fromJson(JsonSafeGet.getJSONObject(jsonObject,"7d"))
            crypto.thirtyDay = CryptoInterval.fromJson(JsonSafeGet.getJSONObject(jsonObject,"30d"))
            crypto.oneYear = CryptoInterval.fromJson(JsonSafeGet.getJSONObject(jsonObject,"365d"))
            crypto.ytd = CryptoInterval.fromJson(JsonSafeGet.getJSONObject(jsonObject,"ytd"))
            return crypto
        }

        fun fromJsonArray(jsonArray: JSONArray): ArrayList<Crypto>{
            val cryptoList = ArrayList<Crypto>()
            for (i in 0 until jsonArray.length()){
                cryptoList.add(fromJson(jsonArray.getJSONObject(i)))
            }
            return cryptoList
        }
    }
}