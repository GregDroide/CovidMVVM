package cl.freedom.wheatermvvm.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.freedom.wheatermvvm.data.repository.CovidRepository

@Suppress("UNCHEKED")
class CovidViewModelFactory(private val repository : CovidRepository) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CovidViewModel(repository) as T
    }
}