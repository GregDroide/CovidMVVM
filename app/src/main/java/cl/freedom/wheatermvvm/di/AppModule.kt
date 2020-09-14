package cl.freedom.wheatermvvm.di

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import cl.freedom.wheatermvvm.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
/*    @Provides
    @Singleton
    fun provideContext(): Context = app*/

    companion object{

        @Provides
        fun provideRequestOptions() : RequestOptions
        {
            return RequestOptions().
            placeholder(R.drawable.white_background)
                .error(R.drawable.white_background)
        }

        @Provides
        fun provideFlideInstance(application: Application, requestOptions: RequestOptions) : RequestManager
        {
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @Provides
        fun provideAppDrawableSplash(application : Application) : Drawable?
        {
            return ContextCompat.getDrawable(application, R.drawable.splash)
        }
    }
}