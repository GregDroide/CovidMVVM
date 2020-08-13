package cl.freedom.desafiomvvm.data.network

import cl.freedom.desafiomvvm.util.NetworkConnectionInterceptor
import cl.freedom.wheatermvvm.data.response.CovidResponse
import cl.freedom.wheatermvvm.util.QueryParameterInterceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "5dc9308387296b977523f9c8a931577d"

interface MyApi {

//http://api.weatherstack.com/current?access_key=5dc9308387296b977523f9c8a931577d&query=New%20York
//https://covid-19-statistics.p.rapidapi.com/reports/total/?rapidapi-key=96afa298cbmsh913f910f914494cp110c39jsn01a32d68445e


    @GET("reports/total/?rapidapi-key=96afa298cbmsh913f910f914494cp110c39jsn01a32d68445e")
    suspend fun getActualReportCovid(
        @Query("date") date : String? = null
    ) : Response<CovidResponse?>


    companion object
    {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor) : MyApi {

            val okkHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpClient)
                .baseUrl("https://covid-19-statistics.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}