package cl.freedom.wheatermvvm.di

import cl.freedom.wheatermvvm.ui.MainActivity
import cl.freedom.wheatermvvm.ui.SplashActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity() : SplashActivity
}