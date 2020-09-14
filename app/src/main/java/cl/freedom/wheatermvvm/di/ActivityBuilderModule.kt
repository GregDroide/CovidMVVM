package cl.freedom.wheatermvvm.di

import cl.freedom.wheatermvvm.ui.dashboard.DashboardActivity
import cl.freedom.wheatermvvm.ui.dashboard.DashboardViewModelsModule
import cl.freedom.wheatermvvm.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [DashboardViewModelsModule::class])
    abstract fun contributeDashboardActivity() : DashboardActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity() : SplashActivity
}