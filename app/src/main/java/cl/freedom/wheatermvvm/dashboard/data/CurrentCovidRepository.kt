package cl.freedom.wheatermvvm.dashboard.data

import cl.freedom.wheatermvvm.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

class CurrentCovidRepository @Inject constructor(private val dao: CurrentCovidDao,
                                                 private val remoteSource: CurrentCovidRemoteDataSource)
{
    val current = resultLiveData(
        databaseQuery = { dao.getCovidData()},
        networkCall = { remoteSource.fetchData() },
        saveCallResult = { dao.upsert(it.currentCovidEntry) }
    )
}