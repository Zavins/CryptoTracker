package utilities

import org.json.JSONObject

class JsonSafeGet{
    companion object {
        fun getInt(jsonObject: JSONObject, name: String): Int? {
            if (jsonObject.has(name)) {
                return jsonObject.getInt(name)
            } else {
                return null
            }
        }

        fun getDouble(jsonObject: JSONObject, name: String): Double? {
            if (jsonObject.has(name)) {
                return jsonObject.getDouble(name)
            } else {
                return null
            }
        }

        fun getString(jsonObject: JSONObject, name: String): String? {
            if (jsonObject.has(name)) {
                return jsonObject.getString(name)
            } else {
                return null
            }
        }

        fun getJSONObject(jsonObject: JSONObject, name: String): JSONObject? {
            if (jsonObject.has(name)) {
                return jsonObject.getJSONObject(name)
            } else {
                return null
            }

        }
    }
}