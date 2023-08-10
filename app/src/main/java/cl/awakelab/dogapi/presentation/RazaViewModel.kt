package cl.awakelab.dogapi.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.dogapi.data.Repositorio
import cl.awakelab.dogapi.data.local.RazaDatabase
import cl.awakelab.dogapi.data.remote.RazaRetrofit
import kotlinx.coroutines.launch

class RazaViewModel(applicacion: Application) : AndroidViewModel(applicacion) {

    fun razasLiveData() = repositorio.obtenerRazaEntity()

    fun detalleLiveData(id: String) = repositorio.obtenerDetalleEntity(id)

    private val repositorio: Repositorio

    init {
        val api = RazaRetrofit.getRetrofitRaza()
        val razaDatabase = RazaDatabase.getDataBase(applicacion).getRazaDao()
        repositorio = Repositorio(api, razaDatabase)
    }

    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }

    fun getDetallePerroVM(id: String) = viewModelScope.launch {
        repositorio.getDetallePerro(id)
    }

}