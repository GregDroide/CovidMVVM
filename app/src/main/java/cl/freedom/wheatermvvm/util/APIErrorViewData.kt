package cl.freedom.wheatermvvm.util

import cl.freedom.wheatermvvm.extensions.empty
import java.io.Serializable
import java.net.HttpURLConnection

open class APIErrorViewData(
    var errorTitle: String? = "Error",
    var errorMessage: String? = null,
    val errorId: String? = null,
    var showTryAgain: Boolean = false,
    var showClose: Boolean = false,
    var showSetting: Boolean = false,
    val errorCode: String? = null,
    val httpStatusCode: String? = HttpURLConnection.HTTP_INTERNAL_ERROR.toString(),
    var realHttpStatusCode: Int? = HttpURLConnection.HTTP_INTERNAL_ERROR
) : Serializable {

    open fun getFooterString(): String? {
        return errorId?.let {
            if (it == "null") {
                String.empty()
            } else {
                "$realHttpStatusCode/$errorId"
            }
        } ?: "$realHttpStatusCode"

    }
}