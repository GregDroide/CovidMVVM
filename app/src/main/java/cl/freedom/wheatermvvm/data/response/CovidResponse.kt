package cl.freedom.wheatermvvm.data.response


import cl.freedom.wheatermvvm.data.entity.CurrentCovidEntry
import com.google.gson.annotations.SerializedName

data class CovidResponse(
    @SerializedName("data")
    val currentCovidEntry: CurrentCovidEntry
)