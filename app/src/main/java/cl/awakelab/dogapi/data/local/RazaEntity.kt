package cl.awakelab.dogapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_raza")
data class RazaEntity(@PrimaryKey val raza: String)





