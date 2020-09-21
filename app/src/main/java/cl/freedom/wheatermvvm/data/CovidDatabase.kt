package cl.freedom.wheatermvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.freedom.wheatermvvm.data.dao.CurrentCovidDao
import cl.freedom.wheatermvvm.data.entity.CurrentCovidEntry

@Database(
    entities = [CurrentCovidEntry::class],
    version = 1,
    exportSchema = true
)
abstract class CovidDatabase : RoomDatabase() {
    abstract fun currentCovidDato() : CurrentCovidDao

    companion object{
        @Volatile private var instance : CovidDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK)
        {
            instance?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(context.applicationContext,
            CovidDatabase::class.java, "covid.db")
                .build()

    }
}