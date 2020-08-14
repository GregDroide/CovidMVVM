package cl.freedom.wheatermvvm.util

import okhttp3.Interceptor
import okhttp3.Response

class QueryParameterInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

       println("First url "+ chain.request().url())

        var url = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("key", "")
            .build()

        println("URL "+ url)

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}