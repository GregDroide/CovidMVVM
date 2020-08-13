package cl.freedom.wheatermvvm

import android.app.Application
import cl.freedom.desafiomvvm.data.network.MyApi
import cl.freedom.desafiomvvm.util.NetworkConnectionInterceptor
import cl.freedom.wheatermvvm.data.CovidViewModelFactory
import cl.freedom.wheatermvvm.data.repository.CovidRepository
import cl.freedom.wheatermvvm.util.QueryParameterInterceptor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy{
        import(androidXModule(this@MVVMApplication))
        bind() from singleton { NetworkConnectionInterceptor(instance())}
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { CovidRepository(instance()) }
        bind() from provider { CovidViewModelFactory(instance())} // para mas de una instancia
    }


}