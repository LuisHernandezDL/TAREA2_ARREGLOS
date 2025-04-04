/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;
import java.io.IOException;// Importa la clase para manejar excepciones al trabajar con archivos
import java.nio.file.Files; // Permite leer archivos
import java.nio.file.Paths; // Permite trabajar con rutas del sistema
import java.time.LocalDateTime;// Clase para manejar fechas y horas (no se usa en este método)
import java.util.*;// Importa utilidades como Map, TreeMap, etc.
	

/**
 *
 * @author Luis
 */
public class EjercicioTreeSetAndMap {
    	   // EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
    public static Map<String, Integer> contarFrecuenciaPalabras(String rutaArchivo) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo)); // Leer todas las líneas del archivo
        Map<String, Integer> frecuencia = new TreeMap<>(); // TreeMap ordenará alfabéticamente

         for (String linea : lineas) { // Recorre cada línea del archivo
            // Convierte a minúsculas, elimina caracteres no alfabéticos, y divide en palabras
            String[] palabras = linea.toLowerCase().replaceAll("[^a-záéíóúüñ ]", "").split("\\s+");

            for (String palabra : palabras) { // Recorre cada palabra en la línea
                if (!palabra.isEmpty()) { // Verifica que la palabra no esté vacía
                    // Incrementa el contador de la palabra o la agrega si no existe
                    frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                }
            }
        }
        return frecuencia; // Retorna el mapa con la frecuencia de cada palabra
    }

   // EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
   
        private final TreeMap<Integer, String> versionesCodigo = new TreeMap<>(); // TreeMap para almacenar versiones, ordenadas por número (clave: versión, valor: código)
        private int versionActual = 0; // Variable para llevar el control del número de versión actual

        public void agregarVersion(String codigo) { // Método para agregar una nueva versión de código
          versionesCodigo.put(++versionActual, codigo); // Incrementa el número de versión y guarda el código en el TreeMap
        }

        public String obtenerVersion(int version) { // Método para obtener una versión específica del código
           return versionesCodigo.getOrDefault(version, "Versión no encontrada"); // Retorna el código si existe, o un mensaje si no se encuentra la versión
        }

        public String obtenerUltimaVersion() { // Método para obtener la última versión registrada
             return versionesCodigo.isEmpty() 
              ? "No hay versiones disponibles" // Si el TreeMap está vacío, muestra un mensaje
             : versionesCodigo.lastEntry().getValue(); // Si no está vacío, obtiene el valor de la última entrada (última versión agregada)
        }

        public void eliminarVersion(int version) { // Método para eliminar una versión específica
               versionesCodigo.remove(version); // Elimina la versión del TreeMap si existe
        }

        // EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)

        private final TreeSet<Evento> eventos = new TreeSet<>(); // TreeSet para almacenar eventos ordenados por fecha (usando Comparable)

        // Método para agregar un nuevo evento al conjunto
        public void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
            eventos.add(new Evento(fecha, nombre, ubicacion)); // Crea un nuevo evento y lo agrega al TreeSet
        }

        // Método para obtener el próximo evento (el más cercano en el tiempo)
        public Evento obtenerProximoEvento() {
            return eventos.stream().findFirst().orElse(null); // Retorna el primer evento (más próximo) o null si no hay eventos
        }

        // Método para listar todos los eventos
        public List<Evento> listarEventos() {
            return new ArrayList<>(eventos); // Convierte el TreeSet en una lista para facilitar la visualización
        }

        // Método para eliminar eventos cuya fecha ya pasó
        public void limpiarEventosPasados() {
            eventos.removeIf(evento -> evento.getFecha().isBefore(LocalDateTime.now())); // Elimina eventos cuya fecha es anterior a la fecha actual
        }

        // Clase interna para representar un evento
        public static class Evento implements Comparable<Evento> {

        private final LocalDateTime fecha; // Fecha y hora del evento
        private final String nombre; // Nombre o título del evento
        private final String ubicacion; // Lugar donde se realizará el evento

        // Constructor que inicializa los atributos del evento
        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
           this.fecha = fecha;
           this.nombre = nombre;
           this.ubicacion = ubicacion;
        }

         // Método getter para obtener la fecha del evento
         public LocalDateTime getFecha() {
            return fecha;
        }

         // Implementación del método compareTo para que los eventos se ordenen por fecha
          @Override
         public int compareTo(Evento otro) {
             return this.fecha.compareTo(otro.fecha); // Compara fechas para ordenar los eventos cronológicamente
        }

        // Representación en texto del evento (útil al imprimir en consola o logs)
        @Override
         public String toString() {
           return nombre + ", " + fecha + ", " + ubicacion; // Formato: Nombre, Fecha, Ubicación
        }
    }

}
