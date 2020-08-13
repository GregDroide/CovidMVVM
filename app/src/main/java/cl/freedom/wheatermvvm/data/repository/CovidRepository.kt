package cl.freedom.wheatermvvm.data.repository
import cl.freedom.desafiomvvm.data.network.MyApi
import cl.freedom.wheatermvvm.data.network.SafeApiRequest
import cl.freedom.wheatermvvm.data.response.CovidResponse
import retrofit2.Response

class CovidRepository(val api : MyApi) : SafeApiRequest()
{
    suspend fun getData(date : String? = null) : CovidResponse?
    {
        return apiRequest { api.getActualReportCovid(date) }
    }
}