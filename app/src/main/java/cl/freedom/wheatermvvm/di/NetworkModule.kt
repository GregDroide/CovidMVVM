package cl.freedom.wheatermvvm.di

import android.app.Application
import android.content.Context
import cl.freedom.desafiomvvm.data.network.MyApi
import cl.freedom.desafiomvvm.util.NetworkConnectionInterceptor
import cl.freedom.wheatermvvm.data.repository.CovidRepository
import cl.freedom.wheatermvvm.data.response.CovidNetworkDataSourceImpl
import cl.freedom.wheatermvvm.util.Const
import cl.freedom.wheatermvvm.util.Const.Companion.API_KEY
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val NAME_BASE_URL = "NAME_BASE_URL"

        @Provides
        fun providesGsonConverterFactory(): GsonConverterFactory {
            return GsonConverterFactory.create()
        }

        @Provides
        fun provideOkHttpClient(requestInterceptor: Interceptor, networkConnectionInterceptor: NetworkConnectionInterceptor): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(networkConnectionInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
        }

        @Provides
        @Named(NAME_BASE_URL)
        fun provideBaseUrlString() = "${Const.PROTOCOL}://${Const.BASE_URL}"


        @Provides
        fun provideRetrofit(client: OkHttpClient, converterFactory: GsonConverterFactory, @Named(NAME_BASE_URL) baseUrl: String): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(converterFactory)
                .client(client)
                .build()
        }

        @Provides
        fun provideApiClient(retrofit: Retrofit): MyApi {
            return retrofit.create(MyApi::class.java)
        }


        @Provides
        fun provideRequestInterceptor() : Interceptor
        {
            return Interceptor {
                chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("rapidapi-key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }
        }

        @Provides
        fun provideNetworkInterceptor(application : Application) : NetworkConnectionInterceptor
        {
            return NetworkConnectionInterceptor(application.applicationContext)
        }

        @Provides
        fun provideCovidNetworkDataSource(api : MyApi) : CovidNetworkDataSourceImpl
        {
            return CovidNetworkDataSourceImpl(api)
        }
    }
}

