package cl.awakelab.dogapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_raza")
class RazaEntity(val raza: String) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}

