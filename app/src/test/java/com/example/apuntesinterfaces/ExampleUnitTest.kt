package com.example.apuntesinterfaces

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun imagenSeCreaCorrectamente() {
        val data = ImageData("Ballena", "imagen", 123)
        assertEquals("Ballena", data.nombreImagen)
        assertEquals("imagen", data.descripImagen)
        assertEquals(123, data.rutaImagen)
    }

    @Test
    fun imagenSeCopiaCorrectamente() {
        val data = ImageData("Ballena", "imagen", 123)
        val copia = data.copy(nombreImagen = "Tortuga")

        assertEquals("Tortuga", copia.nombreImagen)
        assertEquals("imagen", copia.descripImagen)
    }
}