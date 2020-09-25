package cl.freedom.wheatermvvm.dashboard.data

import cl.freedom.wheatermvvm.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

class CurrentCovidRepository @Inject constructor(private val dao: CurrentCovidDao,
                                                 private val remoteSource: CurrentCovidRemoteDataSource)
{


    fun observeCovidData (date: String) = resultLiveData(
        databaseQuery = { dao.getCovidData()},
        networkCall = { remoteSource.fetchData(date) },
        saveCallResult = { dao.upsert(it.currentCovidEntry) }
    )
}