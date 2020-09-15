package cl.freedom.wheatermvvm.di

import cl.freedom.desafiomvvm.data.network.MyApi
import cl.freedom.wheatermvvm.data.repository.CovidRepository
import cl.freedom.wheatermvvm.util.Const
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
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
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
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
                .addConverterFactory(converterFactory)
                .client(client)
                .build()
        }

        @Provides
        fun provideApiClient(retrofit: Retrofit): MyApi {
            return retrofit.create(MyApi::class.java)
        }

/*        @Provides
        @Singleton
        fun provideRepository(api : MyApi) : CovidRepository{
            return CovidRepository(api)
        }*/
    }
    }

