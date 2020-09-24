package cl.freedom.desafiomvvm.data.network

import cl.freedom.desafiomvvm.util.NetworkConnectionInterceptor
import cl.freedom.wheatermvvm.data.response.CovidResponse
import cl.freedom.wheatermvvm.util.QueryParameterInterceptor
import io.reactivex.Flowable
import kotlinx.coroutines.Deferred
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


interface CovidService {

    @GET("reports/total")
    suspend fun getActualReportCovid(
        @Query("date") date : String? = null
    ) : Response<CovidResponse>

}