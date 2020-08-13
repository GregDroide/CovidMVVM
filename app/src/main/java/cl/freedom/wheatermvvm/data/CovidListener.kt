package cl.freedom.wheatermvvm.data

interface CovidListener {
    fun onStarted()
    fun onSuccess(date : String, confirmed : Int, quantity : Int)
    fun onFailure(message : String)
}