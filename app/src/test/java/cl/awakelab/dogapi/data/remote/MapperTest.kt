package cl.awakelab.dogapi.data.remote

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {
        //Given  (dado este valor )
        val url = "http//example.com"
        val id = "id"

        //When   (hago esta acción )
        val resultado = url.toEntity(id)

        //Then   (espero este resultado)
        assertEquals(id, resultado.razaDetalle)
        assertEquals(url, resultado.url)

    }

    @Test
    fun toRazaEntity() {
        //Given
        val raza = "Esta es una raza"

        //When
        val result = raza.toRazaEntity()

        //Then
        assertEquals(raza, result.raza)

    }
}