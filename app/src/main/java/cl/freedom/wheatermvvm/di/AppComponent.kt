package cl.freedom.wheatermvvm.di

import android.app.Application
import cl.freedom.wheatermvvm.application.CovidApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    AppModule::class

])
interface AppComponent : AndroidInjector<CovidApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build() : AppComponent
    }


}