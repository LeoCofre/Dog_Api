package cl.awakelab.dogapi.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: RazaEntity)

    //Para Prueba android
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: List<RazaEntity>)

    @Query("Select * from tabla_raza order by raza desc")
    fun getRazas(): LiveData<List<RazaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetallePerro(razaDetalleEntity: RazaDetalleEntity)

    @Query("Select * from tabla_razas_detalle where razaDetalle like :id")
    fun getImagesRaza(id:String):LiveData<List<RazaDetalleEntity>>



}