package cl.freedom.wheatermvvm.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import cl.freedom.desafiomvvm.util.ApiException
import cl.freedom.wheatermvvm.util.APIErrorViewData
import cl.freedom.wheatermvvm.util.State
import cl.freedom.wheatermvvm.util.isNetworkAvailable
import kotlinx.coroutines.Dispatchers
/*

fun <T, A> resultLiveData(
    isPagination: Boolean = false,
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> Result<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<State<T>> =
    liveData(Dispatchers.IO) {

        if (!isPagination) {
            emit(State.loading())
        }

        val source = databaseQuery.invoke().map {
            if (it != null) {
                State.success(it)
            } else {
                State.errorEmpty("Data is null from database")
            }
        }

        when (val responseStatus = networkCall.invoke()) {
            is Result.Success -> {
                saveCallResult(responseStatus.data!!)
            }

            is Result.Error -> {
                emit(
                    State.error<T>(
                        errorMessage = responseStatus.exception.message,
                        errorViewData = APIErrorViewData("Error title"),
                        error = responseStatus.exception
                    )
                )
            }
        }

        emitSource(source)
    }*/