package cl.freedom.wheatermvvm.data.response


import com.google.gson.annotations.SerializedName

data class CovidResponse(
    @SerializedName("data")
    val `data`: Data
)