/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.test.EjercicioTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;  // Importa la clase a probar

/**
 *
 * @author Luis
 */
public class EjercicioTreeSetAndMapTest {
        private EjercicioTreeSetAndMap ejercicio;

     @BeforeEach
    void setUp() { // Método que se ejecuta antes de cada prueba
        ejercicio = new EjercicioTreeSetAndMap(); // Se inicializa la instancia antes de cada test
    }

     @Test
    void testContarFrecuenciaPalabras() throws IOException { // Prueba del método contarFrecuenciaPalabras
        String rutaArchivo = "testfile.txt"; // Se define el nombre del archivo de prueba
        Files.writeString(Paths.get(rutaArchivo), "Hola mundo, hola Java."); // Se escribe texto en el archivo (simula entrada de usuario)
        Map<String, Integer> frecuencia = EjercicioTreeSetAndMap.contarFrecuenciaPalabras(rutaArchivo); // Se ejecuta el método a probar
        assertEquals(2, frecuencia.get("hola")); // Se espera que "hola" aparezca 2 veces
        assertEquals(1, frecuencia.get("mundo")); // Se espera que "mundo" aparezca 1 vez
        assertEquals(1, frecuencia.get("java")); // Se espera que "java" aparezca 1 vez
    }
 
   
    @Test
    void testRastreadorVersiones() { // Prueba del rastreador de versiones
        ejercicio.agregarVersion("System.out.println('Hola Mundo');"); // Agrega versión 1
        ejercicio.agregarVersion("System.out.println('Hola Java');"); // Agrega versión 2
        assertEquals("System.out.println('Hola Java');", ejercicio.obtenerUltimaVersion()); // Verifica que la última versión sea la segunda
        assertEquals("System.out.println('Hola Mundo');", ejercicio.obtenerVersion(1)); // Verifica que la versión 1 sea la primera agregada
    }

       @Test
    void testGestionEventos() { // Prueba del sistema de gestión de eventos
        LocalDateTime fecha1 = LocalDateTime.of(2025, 4, 15, 14, 0); // Fecha de evento 1
        LocalDateTime fecha2 = LocalDateTime.of(2025, 5, 10, 10, 0); // Fecha de evento 2
        ejercicio.agregarEvento(fecha1, "Taller de Machine Learning", "Sala 3"); // Agrega evento 1
        ejercicio.agregarEvento(fecha2, "Conferencia de Java", "Auditorio A"); // Agrega evento 2
        assertEquals("Taller de Machine Learning, 2025-04-15T14:00, Sala 3", 
            ejercicio.obtenerProximoEvento().toString()); // Verifica que el evento más próximo sea el primero
    }

        @Test
    void testForzarFallo() { // Prueba diseñada para fallar intencionalmente (útil para validar el sistema de pruebas)
        assertEquals("Incorrecto", ejercicio.obtenerUltimaVersion()); // Esta prueba fallará si obtenerUltimaVersion devuelve algo diferente
    }
    
}
