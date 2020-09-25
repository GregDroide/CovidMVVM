package cl.freedom.wheatermvvm.data

interface CovidListener {
    fun onSuccess(date : String, confirmed : Double, deaths : Double)
    fun onFailure(message : String)
    fun onLoading()
}