package cl.freedom.wheatermvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.freedom.wheatermvvm.data.entity.CURRENT_COVID_ID
import cl.freedom.wheatermvvm.data.entity.CurrentCovidEntry
import cl.freedom.wheatermvvm.data.entity.CurrentCovidEntryMapper

@Dao
interface CurrentCovidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(covidEntry : CurrentCovidEntry)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from current_covid where  id = $CURRENT_COVID_ID")
    fun getCovidData() : LiveData<CurrentCovidEntryMapper>
}