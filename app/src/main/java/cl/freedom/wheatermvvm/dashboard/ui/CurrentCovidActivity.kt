package cl.freedom.wheatermvvm.dashboard.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.freedom.desafiomvvm.util.toast
import cl.freedom.wheatermvvm.R
import cl.freedom.wheatermvvm.data.Result
import cl.freedom.wheatermvvm.di.injectViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CurrentCovidActivity : DaggerAppCompatActivity()
{
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CurrentCovidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CurrentCovidViewModel::class.java)

        viewModel.currentCovid.observe(this, Observer { result ->
            when(result.status)
            {
                Result.Status.SUCCESS -> {
                    toast("Hide loading")
                    println(result.data.toString())
                    result.data?.let { toast(it.toString()) }
                }
                Result.Status.LOADING -> toast("Show loading")
                Result.Status.ERROR -> {
                    toast("Error")
              }
            }
        })
    }


}
