package cl.freedom.wheatermvvm.data.response

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.freedom.desafiomvvm.data.network.CovidService
import cl.freedom.desafiomvvm.util.NoInternetException
import javax.inject.Inject

class CovidNetworkDataSourceImpl @Inject constructor(private val api : CovidService) : CovidNetworkDataSource {

    private val _downloadedCurrentCovid = MutableLiveData<CovidResponse>()

    override val downloadedCurrentCovid: LiveData<CovidResponse>
        get() = _downloadedCurrentCovid

    override suspend fun fetchCurrentCovid(date: String) {
        try {
            /*  val fetchedCurrentCovid = api.
            getActualReportCovid(date).await()

             _downloadedCurrentCovid.postValue(fetchedCurrentCovid)*/
        }
        catch (e: NoInternetException)
        {
            Log.e("Connectivity", "No internet connection.")
        }
    }
}