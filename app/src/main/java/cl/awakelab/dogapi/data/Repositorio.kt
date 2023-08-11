package cl.awakelab.dogapi.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelab.dogapi.data.local.RazaDao
import cl.awakelab.dogapi.data.local.RazaDetalleEntity
import cl.awakelab.dogapi.data.local.RazaEntity
import cl.awakelab.dogapi.data.remote.RazaApi
import cl.awakelab.dogapi.data.remote.toEntity
import cl.awakelab.dogapi.data.remote.toRazaEntity

class Repositorio(private val razaApi: RazaApi, private val razaDao: RazaDao) {

    fun obtenerRazaEntity(): LiveData<List<RazaEntity>> = razaDao.getRazas()

    fun obtenerDetalleEntity(id: String): LiveData<List<RazaDetalleEntity>> =
        razaDao.getImagesRaza(id)

    suspend fun getRazas() {
        val response = razaApi.getData()            // Acá llegan los datos
        if (response.isSuccessful) {                 // Llegaron los datos?
            val message = response.body()!!.message // Solo sacando la parte de message, sin status
            val keys = message.keys
            keys.forEach { raza ->
                val razaEntity = raza.toRazaEntity()
                razaDao.insertRaza(razaEntity)
            }
        } else
            Log.e("Repositorio", response.errorBody().toString())

    }

    suspend fun getDetallePerro(id: String) {
        val response = razaApi.getDetallePerro(id)
        if (response.isSuccessful) {
            response.body()!!.message.forEach { url ->
                val razaDetalleEntity = url.toEntity(id) //Transformado para testear
                razaDao.insertDetallePerro(razaDetalleEntity)
            }

        } else {
            Log.e("Repositorio", response.errorBody().toString())
        }
    }


}