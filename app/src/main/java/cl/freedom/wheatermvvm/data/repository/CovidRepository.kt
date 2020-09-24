package cl.freedom.wheatermvvm.data.repository
import androidx.lifecycle.LiveData
import cl.freedom.wheatermvvm.dashboard.data.CurrentCovidDao
import cl.freedom.wheatermvvm.dashboard.data.CurrentCovidMapper
import cl.freedom.wheatermvvm.data.response.CovidNetworkDataSource
import cl.freedom.wheatermvvm.data.response.CovidResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CovidRepository(private val currentCovidDao: CurrentCovidDao,
                      private val covidNetworkDataSource: CovidNetworkDataSource)
{
    init {
        covidNetworkDataSource.downloadedCurrentCovid.observeForever{
            newCurrentCovid ->
            persistFetchedCurrentCovid(newCurrentCovid)
        }
    }

    private suspend fun initCovidData(date : String)
    {
        if(isFetchedCurrentNeeded(date))
        {
            fetchCurrentCovid(date)
        }
    }

    private suspend fun fetchCurrentCovid(date : String)
    {
        covidNetworkDataSource.fetchCurrentCovid(date)
    }


    suspend fun getCurrentCovid(date : String) : LiveData<CurrentCovidMapper>
    {
        return withContext(Dispatchers.IO){
            return@withContext currentCovidDao.getCovidData()
        }
    }

    private fun persistFetchedCurrentCovid(fetchedCovid: CovidResponse)
    {
        GlobalScope.launch(Dispatchers.IO) {
            currentCovidDao.upsert(fetchedCovid.currentCovidEntry)
        }
    }

    private fun isFetchedCurrentNeeded(date : String) : Boolean
    {
        //you must check that the date exist in the room database
        return true
    }


}