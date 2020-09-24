package cl.freedom.wheatermvvm.dashboard.data

import androidx.room.ColumnInfo
import androidx.room.RoomWarnings

data class CurrentCovidMapper (
    @ColumnInfo(name = "date")
    val date : String,
    @ColumnInfo(name = "confirmed")
    val confirmed : Double,
    @ColumnInfo(name = "deaths")
    val deaths: Double)
