package cl.freedom.wheatermvvm.di

import cl.freedom.wheatermvvm.dashboard.ui.CurrentCovidActivity
import cl.freedom.wheatermvvm.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeCovidCurrentActivity() : CurrentCovidActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity() : SplashActivity
}