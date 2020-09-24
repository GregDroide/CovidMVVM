package cl.freedom.wheatermvvm.data

import androidx.lifecycle.ViewModel
import javax.inject.Inject


private const val TAG = "CovidViewModel"

class CovidViewModel @Inject constructor() : ViewModel()
{

    var covidListener: CovidListener? = null

/*    fun getData(date : String? = null)
    {
        Coroutines.main {

            try {
                val response = covidRepository.getData(date)
                response!!.data?.let {
                    covidListener?.onSuccess(response!!.data!!.date, response!!.data!!.confirmed, response!!.data!!.deaths)
                    return@let
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