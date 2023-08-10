package cl.awakelab.dogapi.data.local

import androidx.room.Entity

@Entity(tableName = "tabla_razas_detalle", primaryKeys = ["razaDetalle", "url"])
data class RazaDetalleEntity(
    val razaDetalle: String,
    val url: String
)