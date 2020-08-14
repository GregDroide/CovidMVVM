package cl.freedom.desafiomvvm.data.network

import cl.freedom.desafiomvvm.util.NetworkConnectionInterceptor
import cl.freedom.wheatermvvm.data.response.CovidResponse
import cl.freedom.wheatermvvm.util.QueryParameterInterceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query


interface MyApi {

//https://covid-19-statistics.p.rapidapi.com/reports/total/?rapidapi-key=96afa298cbmsh913f910f914494cp110c39jsn01a32d68445e


    @GET("reports/total/?rapidapi-key=96afa298cbmsh913f910f914494cp110c39jsn01a32d68445e")
    suspend fun getActualReportCovid(
        @Query("date") date : String? = null
    ) : Response<CovidResponse?>

    @GET("reports/total/?rapidapi-key=96afa298cbmsh913f910f914494cp110c39jsn01a32d68445e")
    suspend fun getCovidList(
        @Query("date") date : String? = null
    ) : Response<CovidResponse?>



    companion object
    {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor) : MyApi {

            val interceptor =  HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            val okkHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(interceptor)
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