package cl.freedom.wheatermvvm.dashboard.data

import cl.freedom.desafiomvvm.data.network.CovidService
import cl.freedom.wheatermvvm.api.BaseDataSource
import javax.inject.Inject

class CurrentCovidRemoteDataSource @Inject constructor(private val service: CovidService) : BaseDataSource() {

    suspend fun fetchData() = getResult { service.getActualReportCovid("2020-04-07") }
}