package network
import android.app.Application
import android.util.Log
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import models.Crypto
import okhttp3.Headers

/*
 *
 * This is the object responsible for communicating with a REST API.
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes:
 *   https://github.com/scribejava/scribejava/tree/master/scribejava-apis/src/main/java/com/github/scribejava/apis
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 *
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 *
 */


//key=d489d947fe979cf49117677d2e9946450f100441&interval=1d,30d&per-page=100&page=2"
class RestClient() : Application(){
    companion object {
        const val TAG = "RESTCLIENT"
        const val API_URL = "https://api.nomics.com/v1/currencies/ticker"
    }

    private val client = AsyncHttpClient()

    private fun getAPI(params_dict: Map<String, String>, callback: (cryptoList: List<Crypto>)->Unit) {
        val params = RequestParams()
        params["key"] = "d489d947fe979cf49117677d2e9946450f100441"
        params_dict.forEach { param ->
            params[param.key] = param.value
        }
        client[API_URL, params, object :
            JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d(TAG, json.jsonArray.toString())
                val cryptoList = Crypto.fromJsonArray(json.jsonArray)
                callback.invoke(cryptoList)
                // Access a JSON object response with `json.jsonObject`
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Error: " + statusCode.toString() + headers.toString())
            }
        }]
    }

    //Use getCryptoInfoList to get a list of crypto info.
    fun getCryptoInfoList(page: Number, callback: (cryptoList: List<Crypto>)->Unit){
        this.getAPI(
            mapOf(
                "interval" to "1h,1d,7d,30d,365d,ytd",
                "per-page" to "100",
                "page" to page.toString()
            ),
        ){
            cryptoList: List<Crypto>->
            callback.invoke(cryptoList)
        }
    }
}

