package cl.awakelab.dogapi.data.remote

import cl.awakelab.dogapi.data.local.RazaDetalleEntity
import cl.awakelab.dogapi.data.local.RazaEntity

//______Desde aquí creamos los Test___

//Función de extensión
fun String.toEntity(id: String): RazaDetalleEntity = RazaDetalleEntity(id, this)

fun String.toRazaEntity(): RazaEntity = RazaEntity(this)