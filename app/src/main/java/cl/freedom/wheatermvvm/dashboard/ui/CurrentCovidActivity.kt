package cl.freedom.wheatermvvm.dashboard.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.freedom.desafiomvvm.util.toast
import cl.freedom.wheatermvvm.data.CovidListener
import cl.freedom.wheatermvvm.databinding.ActivityMainBinding
import cl.freedom.wheatermvvm.util.DateUtil
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject

class CurrentCovidActivity : DaggerAppCompatActivity(), CovidListener
{

    private var mYear = 0
    private  var mMonth:Int = 0
    private  var mDay:Int = 0

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CurrentCovidViewModel

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViewModel()
    }


    private fun initViewModel()
    {
        viewModel = ViewModelProvider(this, viewModelFactory).get(CurrentCovidViewModel::class.java)
        viewModel.covidListener = this
        viewModel.fetchCurrentCovid(DateUtil.getYesterday(), this)
    }

    fun getCalendar(v : View)
    {
        val c = Calendar.getInstance()
        mYear = c[Calendar.YEAR]
        mMonth = c[Calendar.MONTH]
        mDay = c[Calendar.DAY_OF_MONTH]
        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                val dateFormat = DateUtil.dateFormat(dayOfMonth, monthOfYear + 1, year)
                viewModel.fetchCurrentCovid(dateFormat, this)
            }, mYear, mMonth, mDay
        )
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000)
        val calendar = Calendar.getInstance()
        calendar.set(2020, 0, 23)

        datePickerDialog.getDatePicker().setMinDate(calendar.timeInMillis)
        datePickerDialog.show()
    }

    override fun onSuccess(date: String, confirmed: Double, deaths: Double) {
        binding.date.text = DateUtil.dateFormat(date)
        binding.confirmed.text = String.format("%.0f",confirmed)
        binding.deaths.text = String.format("%.0f", deaths)
    }

    override fun onFailure(message: String) {
        toast(message)
    }

    override fun onLoading() {
        toast("Cargando datos..")
    }
}
