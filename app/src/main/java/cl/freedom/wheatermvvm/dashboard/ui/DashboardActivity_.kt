package cl.freedom.wheatermvvm.dashboard.ui

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import cl.freedom.desafiomvvm.util.toast
import cl.freedom.wheatermvvm.R
import cl.freedom.wheatermvvm.data.CovidListener
import cl.freedom.wheatermvvm.data.response.CovidNetworkDataSourceImpl
import cl.freedom.wheatermvvm.databinding.ActivityMainBinding
import cl.freedom.wheatermvvm.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*
import javax.inject.Inject

private const val TAG = "Dashboard"

class DashboardActivity_ : DaggerAppCompatActivity(), CovidListener, View.OnClickListener {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var covidNetworkDataSource: CovidNetworkDataSourceImpl

    private lateinit var binding : ActivityMainBinding
    //private lateinit var viewModel: CovidViewModel
    private var mYear = 0
    private  var mMonth:Int = 0
    private  var mDay:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //(application as CovidApplication).covidComponent.inject(this)
        //viewModel = ViewModelProvider(this, providerFactory).get(CovidViewModel::class.java)
        
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //viewModel.covidListener = this
        binding.btnDate.setOnClickListener(this)
        firstData()
    }

    override fun onStarted() {
        toast("Comenzó")
    }

    override fun onSuccess(date: String, confirmed: Int, deaths: Int) {
        val dateFormated = dateFormat(date)
        binding.date.setText(dateFormated)
        binding.confirmed.setText(confirmed.toString())
        binding.quantity.setText(deaths.toString())
    }

    override fun onFailure(message: String) {
        println(message)
        toast(message)
    }

    override fun onClick(v: View?) {

        if (v != null) {
            if (v.id === binding.btnDate.id) {

                val c = getInstance()
                mYear = c[YEAR]
                mMonth = c[MONTH]
                mDay = c[DAY_OF_MONTH]
                val datePickerDialog = DatePickerDialog(
                    this,
                    OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        val dateFormat = dateFormat(dayOfMonth, monthOfYear + 1, year)
                        //viewModel.getData(dateFormat)
                    }, mYear, mMonth, mDay
                )
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000)
                val calendar = getInstance()
                calendar.set(2020, 0, 23)

                datePickerDialog.getDatePicker().setMinDate(calendar.timeInMillis)
                datePickerDialog.show()
            }
        }
    }

    private fun firstData()
    {
        val today = Date()
        val yesterday = Date(today.time - 1000 * 60 * 60 * 24)
        val yesterdayFormated = SimpleDateFormat("yyyy-MM-dd").format(yesterday)


/*        covidNetworkDataSource.downloadedCurrentCovid.observe(this, androidx.lifecycle.Observer {
            println("Data covid: $it")
        })



        GlobalScope.launch(Dispatchers.Main) {
           covidNetworkDataSource.fetchCurrentCovid("2020-04-07")
        }*/


        //viewModel.getData(yesterdayFormated)
    }

    private fun dateFormat(date : String) : String
    {
        val monthDate = SimpleDateFormat("MMM", Locale("es", "ES"))
        val dayDate = SimpleDateFormat("dd", Locale("es", "ES"))
        val yearDate = SimpleDateFormat("yyyy", Locale("es", "ES"))
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = simpleDateFormat.parse(date)

        val monthName = monthDate.format(date)
        val day = dayDate.format(date)
        val year = yearDate.format(date)

        return day + " de "+ monthName + " del "+ year
    }

    private fun dateFormat(dayOfMonth : Int, monthOfYear : Int, year : Int) : String
    {
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
        } catch (e  : Exception) {
        e.printStackTrace();
    }
        return ""
    }

}