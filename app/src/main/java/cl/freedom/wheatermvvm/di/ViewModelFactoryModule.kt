package cl.freedom.wheatermvvm.di

import androidx.lifecycle.ViewModelProvider
import cl.freedom.wheatermvvm.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory : ViewModelProviderFactory) : ViewModelProvider.Factory

    companion object
    {
        /*
        The method is the same that bindViewModelFactory
        @Provides
        fun bindFactory(factory : ViewModelProviderFactory) : ViewModelProvider.Factory
        {
            return factory
        }
        */

    }
}