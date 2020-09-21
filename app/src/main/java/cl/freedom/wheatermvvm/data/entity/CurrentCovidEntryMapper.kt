package cl.freedom.wheatermvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.RoomWarnings

data class CurrentCovidEntryMapper (
    @ColumnInfo(name = "date")
    val date : String,
    @ColumnInfo(name = "confirmed")
    val confirmed : Double,
    @ColumnInfo(name = "deaths")
    val deaths: Double)
