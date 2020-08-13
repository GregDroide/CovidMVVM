package cl.freedom.wheatermvvm.data

import androidx.lifecycle.ViewModel
import cl.freedom.desafiomvvm.util.Coroutines
import cl.freedom.desafiomvvm.util.NoInternetException
import cl.freedom.wheatermvvm.data.repository.CovidRepository

class CovidViewModel(private val covidRepository: CovidRepository) : ViewModel()
{
    var covidListener: CovidListener? = null

    fun getData(date : String? = null)
    {

        println("Entrando")

        Coroutines.main {
            println("Coroutine init")
            try {
                val response = covidRepository.getData(date)
                if(response.isSuccessful)
                {
                    if(response.body() != null)
                    {
                        //si body es distinto a null
                        println("Covid "+ response.body())
                        val date = response.body()!!.data.date
                        val confirmed = response.body()!!.data.confirmed
                        val quantity = response.body()!!.data.confirmed
                        covidListener?.onSuccess(date, confirmed, quantity)
                    }

                }
                else
                {
                    covidListener?.onFailure(response.code().toString())
                }
            }
            catch (e : NoInternetException)
            {
                covidListener?.onFailure(e.message!!)
            }


        }
    }
}