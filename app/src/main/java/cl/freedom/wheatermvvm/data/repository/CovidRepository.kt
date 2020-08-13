package cl.freedom.wheatermvvm.data.repository
import cl.freedom.desafiomvvm.data.network.MyApi
import cl.freedom.wheatermvvm.data.response.CovidResponse
import retrofit2.Response

class CovidRepository(val api : MyApi)
{
    suspend fun getData(date : String? = null) : Response<CovidResponse>
    {
        return api.getActualReportCovid(date)
    }
}