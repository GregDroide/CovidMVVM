package cl.freedom.wheatermvvm.data.response


import cl.freedom.wheatermvvm.dashboard.data.CurrentCovidEntry
import com.google.gson.annotations.SerializedName

data class CovidResponse(
    @SerializedName("data")
    val currentCovidEntry: CurrentCovidEntry
)