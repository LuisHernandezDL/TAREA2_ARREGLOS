/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.LinkedList;  // Importa la clase LinkedList de Java
import java.util.HashSet;     // Importa la clase HashSet para manejo eficiente de elementos únicos
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;


public class EjercicioLinkedList {

    // Problema 1: Método para eliminar duplicados en una LinkedList<Integer>
    public LinkedList<Integer> eliminarDuplicados(LinkedList<Integer> lista) {
        HashSet<Integer> elementosVistos = new HashSet<>();  // Crea un conjunto para almacenar elementos únicos
        LinkedList<Integer> resultado = new LinkedList<>();  // Crea una nueva lista para almacenar el resultado sin duplicados

        // Itera sobre los elementos de la lista original
        for (Integer num : lista) {
            // Si el número no está en el conjunto de elementos vistos
            if (!elementosVistos.contains(num)) {
                resultado.add(num);       // Agrega el número a la lista resultado
                elementosVistos.add(num); // Agrega el número al conjunto de elementos vistos
            }
        }
        return resultado;  // Devuelve la lista sin duplicados
    }

    // Problema 2: Método para invertir una LinkedList<String> sin usar otra lista o ArrayList
    public LinkedList<String> invertirLista(LinkedList<String> lista) {
        int n = lista.size();  // Obtiene el tamaño de la lista
        for (int i = 0; i < n / 2; i++) {  // Itera hasta la mitad de la lista
            String temp = lista.get(i);  // Guarda el elemento en la posición 'i'
            lista.set(i, lista.get(n - i - 1));  // Reemplaza el elemento en 'i' con el de la posición opuesta
            lista.set(n - i - 1, temp);  // Reemplaza el elemento en la posición opuesta con el valor original de 'i'
        }
        return lista;  // Devuelve la lista invertida
    }

    // Problema 3: Método para mezclar dos listas ordenadas de enteros en una nueva LinkedList<Integer>
    public LinkedList<Integer> mezclarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> resultado = new LinkedList<>();  // Crea una nueva lista para el resultado
        int i = 0, j = 0;  // Inicializa índices para recorrer ambas listas

        // Mezcla los elementos de ambas listas mientras haya elementos en ambas
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {  // Si el elemento en lista1 es menor
                resultado.add(lista1.get(i++));   // Agrega el elemento de lista1 y avanza el índice 'i'
            } else {
                resultado.add(lista2.get(j++));   // Agrega el elemento de lista2 y avanza el índice 'j'
            }
        }

        // Añadir los elementos restantes de lista1 (si hay)
        while (i < lista1.size()) resultado.add(lista1.get(i++));

        // Añadir los elementos restantes de lista2 (si hay)
        while (j < lista2.size()) resultado.add(lista2.get(j++));

        return resultado;  // Devuelve la lista mezclada
    }
}
