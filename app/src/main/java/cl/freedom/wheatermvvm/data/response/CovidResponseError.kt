package cl.freedom.wheatermvvm.data.response


import com.google.gson.annotations.SerializedName

data class CovidResponseError(
    @SerializedName("data")
    val `data`: List<Any>
)