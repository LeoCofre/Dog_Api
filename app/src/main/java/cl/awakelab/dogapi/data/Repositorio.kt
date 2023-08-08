package cl.awakelab.dogapi.data

import cl.awakelab.dogapi.data.local.RazaDao
import cl.awakelab.dogapi.data.local.RazaEntity
import cl.awakelab.dogapi.data.remote.RazaApi

class Repositorio(private val razaApi: RazaApi, private val razaDao: RazaDao) {

    suspend fun getRazas() {
        val response = razaApi.getData()            // Acá llegan los datos
        if (response.isSuccessful){                 // Llegaron los datos?
            val message = response.body()!!.message // Solo sacando la parte de message, sin status
            val keys = message.keys
            keys.forEach {
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }
        }
    }
}