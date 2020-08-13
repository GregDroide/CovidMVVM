package cl.freedom.desafiomvvm.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(context : Context) : Interceptor {

    private val applicationContext = context.applicationContext

    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isInternetAvailable())
            throw NoInternetException("No hay internet")

        println("URL "+ chain.request().url())

        return chain.proceed(chain.request())
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isInternetAvailable(): Boolean {

        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }

        return false
    }


}