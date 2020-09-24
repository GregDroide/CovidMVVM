package cl.freedom.wheatermvvm.dashboard.ui

import androidx.lifecycle.ViewModel
import cl.freedom.wheatermvvm.dashboard.data.CurrentCovidRepository
import javax.inject.Inject

class CurrentCovidViewModel @Inject constructor(repository: CurrentCovidRepository) : ViewModel() {

    val currentCovid = repository.current
}