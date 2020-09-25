package cl.freedom.wheatermvvm.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    companion object {

         fun dateFormat(date: String): String {
            val monthDate = SimpleDateFormat("MMM", Locale("es", "ES"))
            val dayDate = SimpleDateFormat("dd", Locale("es", "ES"))
            val yearDate = SimpleDateFormat("yyyy", Locale("es", "ES"))
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            val date = simpleDateFormat.parse(date)

            val monthName = monthDate.format(date)
            val day = dayDate.format(date)
            val year = yearDate.format(date)

            return day + " de " + monthName + " del " + year
        }

        fun dateFormat(dayOfMonth: Int, monthOfYear: Int, year: Int): String {
            try {
                if (monthOfYear < 10 && dayOfMonth < 10) {
                    val fmonth = "0" + monthOfYear;
                    val month = Integer.parseInt(fmonth);
                    val fDate = "0" + dayOfMonth;
                    val paddedMonth: String = String.format("%02d", month);
                    return year.toString() + "-" + paddedMonth + "-" + fDate

                } else {
                    val fmonth = "0" + monthOfYear;
                    val month = Integer.parseInt(fmonth);
                    val paddedMonth = String.format("%02d", month);
                    return year.toString() + "-" + paddedMonth + "-" + dayOfMonth.toString()
                }
            } catch (e: Exception) {
                e.printStackTrace();
            }
            return ""
        }

        fun getYesterday() : String
        {
            val today = Date()
            val yesterday = Date(today.time - 1000 * 60 * 60 * 24)
            return SimpleDateFormat("yyyy-MM-dd").format(yesterday)
        }
    }
}