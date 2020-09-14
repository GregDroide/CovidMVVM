package cl.freedom.wheatermvvm.data

import android.util.Log
import androidx.lifecycle.ViewModel
import cl.freedom.desafiomvvm.util.ApiException
import cl.freedom.desafiomvvm.util.Coroutines
import cl.freedom.desafiomvvm.util.NoInternetException
import cl.freedom.wheatermvvm.data.repository.CovidRepository
import java.io.IOException
import javax.inject.Inject


private const val TAG = "CovidViewModel"

class CovidViewModel @Inject constructor() : ViewModel()
{

    init {
        Log.d(TAG, "Inicio viewmodel")
    }

    var covidListener: CovidListener? = null

  /*  fun getData(date : String? = null)
    {
        Coroutines.main {

            try {
                val response = covidRepository.getData(date)
                response!!.data?.let {
                    covidListener?.onSuccess(response!!.data!!.date, response!!.data!!.confirmed, response!!.data!!.deaths)
                    return@main
                }

            }catch (e : ApiException)
            {
                covidListener?.onFailure(e.message!!)
            }
            catch (e: NoInternetException)
            {
                covidListener?.onFailure(e.message!!)
            }
            catch (e : IOException)
            {
                covidListener?.onFailure(e.message!!)
            }

        }
    }*/
}