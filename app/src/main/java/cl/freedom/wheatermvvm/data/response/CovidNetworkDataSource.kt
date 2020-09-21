package cl.freedom.wheatermvvm.data.response

import androidx.lifecycle.LiveData
import java.util.*

interface CovidNetworkDataSource {
    val downloadedCurrentCovid : LiveData<CovidResponse>

    suspend fun fetchCurrentCovid(
        string : String
    )

}