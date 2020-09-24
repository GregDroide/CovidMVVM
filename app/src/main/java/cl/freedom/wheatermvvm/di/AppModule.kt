package cl.freedom.wheatermvvm.di

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import cl.freedom.desafiomvvm.data.network.CovidService
import cl.freedom.wheatermvvm.R
import cl.freedom.wheatermvvm.dashboard.data.CurrentCovidRemoteDataSource
import cl.freedom.wheatermvvm.data.CovidDatabase
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    companion object{

        @Provides
        fun provideRequestOptions() : RequestOptions
        {
            return RequestOptions().
            placeholder(R.drawable.white_background)
                .error(R.drawable.white_background)
        }

        @Provides
        fun provideGlideInstance(application: Application, requestOptions: RequestOptions) : RequestManager
        {
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @Provides
        fun provideAppDrawableSplash(application : Application) : Drawable
        {
            return ContextCompat.getDrawable(application, R.drawable.splash)!!
        }

        @Provides
        fun provideCovidSetDao(db: CovidDatabase) = db.currentCovidDato()

        @Provides
        fun provideDb(app: Application) = CovidDatabase.getInstance(app)

        @Provides
        fun provideCovidSetRemoteDataSource(covidService: CovidService)
                = CurrentCovidRemoteDataSource(covidService)

    }
}