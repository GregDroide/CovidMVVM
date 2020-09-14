package cl.freedom.wheatermvvm.ui.dashboard

import androidx.lifecycle.ViewModel
import cl.freedom.wheatermvvm.data.CovidViewModel
import cl.freedom.wheatermvvm.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DashboardViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CovidViewModel::class)
    abstract fun bindThemeViewModel(viewModel: CovidViewModel): ViewModel

}