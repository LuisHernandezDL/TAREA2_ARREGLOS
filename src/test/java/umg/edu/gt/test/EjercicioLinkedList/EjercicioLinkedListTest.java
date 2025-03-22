/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.test.EjercicioLinkedList;

import org.junit.jupiter.api.Test;  // Importa la anotación @Test para indicar métodos de prueba
import static org.junit.jupiter.api.Assertions.*;  // Importa métodos de aserción
import java.util.LinkedList;  // Importa LinkedList
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;  // Importa la clase a probar

public class EjercicioLinkedListTest {

    // Prueba 1: Test para verificar la eliminación de duplicados
    @Test
    public void testEliminarDuplicados() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();  // Crea una instancia de la clase a probar
        LinkedList<Integer> lista = new LinkedList<>();  // Crea una lista de enteros
        lista.add(1); lista.add(2); lista.add(2); lista.add(3); lista.add(1);  // Agrega elementos (con duplicados)

        LinkedList<Integer> resultado = ejercicio.eliminarDuplicados(lista);  // Llama al método que elimina duplicados
        LinkedList<Integer> esperado = new LinkedList<>();  // Crea una lista esperada (sin duplicados)
        esperado.add(1); esperado.add(2); esperado.add(3);

        assertEquals(esperado, resultado);  // Verifica que el resultado sea igual a la lista esperada
    }

    // Prueba 2: Test para verificar la inversión de una lista
    @Test
    public void testInvertirLista() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();  // Crea una instancia de la clase a probar
        LinkedList<String> lista = new LinkedList<>();  // Crea una lista de cadenas
        lista.add("A"); lista.add("B"); lista.add("C");  // Agrega elementos a la lista

        LinkedList<String> resultado = ejercicio.invertirLista(lista);  // Llama al método que invierte la lista
        LinkedList<String> esperado = new LinkedList<>();  // Crea la lista esperada (invertida)
        esperado.add("C"); esperado.add("B"); esperado.add("A");

        assertEquals(esperado, resultado);  // Verifica que el resultado sea igual a la lista esperada
    }

    // Prueba 3: Test para verificar la mezcla de dos listas ordenadas
    @Test
    public void testMezclarListas() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();  // Crea una instancia de la clase a probar
        LinkedList<Integer> lista1 = new LinkedList<>();  // Crea la primera lista de enteros
        lista1.add(1); lista1.add(3); lista1.add(5);  // Agrega elementos ordenados
        LinkedList<Integer> lista2 = new LinkedList<>();  // Crea la segunda lista de enteros
        lista2.add(2); lista2.add(4); lista2.add(6);  // Agrega elementos ordenados

        LinkedList<Integer> resultado = ejercicio.mezclarListas(lista1, lista2);  // Llama al método que mezcla las listas
        LinkedList<Integer> esperado = new LinkedList<>();  // Crea la lista esperada (mezclada)
        esperado.add(1); esperado.add(2); esperado.add(3); esperado.add(4);
        esperado.add(5); esperado.add(6);

        assertEquals(esperado, resultado);  // Verifica que el resultado sea igual a la lista esperada
    }

    // Prueba 4: Test para forzar un fallo intencional
    @Test
    public void testForzarFallo() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();  // Crea una instancia de la clase a probar
        LinkedList<Integer> lista1 = new LinkedList<>();  // Crea la primera lista
        lista1.add(1); lista1.add(2); lista1.add(3);  // Agrega elementos
        LinkedList<Integer> lista2 = new LinkedList<>();  // Crea la segunda lista
        lista2.add(4); lista2.add(5); lista2.add(6);  // Agrega elementos

        LinkedList<Integer> resultado = ejercicio.mezclarListas(lista1, lista2);  // Mezcla las listas
        assertEquals(lista1, resultado);  // Verifica que la lista mezclada sea igual a lista1 por lo tanto fallara
    }
    
    }