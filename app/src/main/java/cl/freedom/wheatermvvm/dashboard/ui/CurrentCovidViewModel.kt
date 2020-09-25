package cl.freedom.wheatermvvm.dashboard.ui

import androidx.lifecycle.*
import cl.freedom.desafiomvvm.util.toast
import cl.freedom.wheatermvvm.dashboard.data.CurrentCovidMapper
import cl.freedom.wheatermvvm.dashboard.data.CurrentCovidRepository
import cl.freedom.wheatermvvm.data.CovidListener
import cl.freedom.wheatermvvm.data.Result
import cl.freedom.wheatermvvm.data.response.CovidResponse
import cl.freedom.wheatermvvm.util.State
import javax.inject.Inject

class CurrentCovidViewModel @Inject constructor(private val repository: CurrentCovidRepository) : ViewModel()
{
    var covidListener : CovidListener? = null

    fun fetchCurrentCovid(date: String, lifecycleOwner: LifecycleOwner)
    {
        repository.observeCovidData(date).observe(
            lifecycleOwner,
            Observer { result ->
            when(result.status)
            {
                Result.Status.SUCCESS -> {
                    println(result.data.toString())
                    result.data?.let {
                       covidListener?.onSuccess(it.date, it.confirmed, it.deaths)
                    }
                }
                Result.Status.LOADING -> {
                    println("Show loading")
                    covidListener?.onLoading()
                }
                    Result.Status.ERROR -> {
                    covidListener?.onFailure("Falló, intente más tarde")
                }
            }
        })
    }
}