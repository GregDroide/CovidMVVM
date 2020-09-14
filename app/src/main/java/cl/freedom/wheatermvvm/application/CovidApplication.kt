package cl.freedom.wheatermvvm.application

import android.app.Application
import cl.freedom.wheatermvvm.di.AppComponent
import cl.freedom.wheatermvvm.di.AppModule
import cl.freedom.wheatermvvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class CovidApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }


}