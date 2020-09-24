package cl.freedom.wheatermvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.freedom.wheatermvvm.dashboard.ui.CurrentCovidViewModel
import cl.freedom.wheatermvvm.data.CovidViewModel
import cl.freedom.wheatermvvm.di.ViewModelKey
import cl.freedom.wheatermvvm.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CurrentCovidViewModel::class)
    abstract fun bindThemeViewModel(viewModel: CurrentCovidViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}