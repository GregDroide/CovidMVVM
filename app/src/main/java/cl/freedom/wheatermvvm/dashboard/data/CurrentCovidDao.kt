package cl.freedom.wheatermvvm.dashboard.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CurrentCovidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(covidEntry : CurrentCovidEntry)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from current_covid where  id = $CURRENT_COVID_ID")
    fun getCovidData() : LiveData<CurrentCovidMapper>
}