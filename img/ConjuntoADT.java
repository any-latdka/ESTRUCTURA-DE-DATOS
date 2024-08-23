/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conjuntoadt;

/**
 *
 * @author HP
 */
import java.util.Set;
import java.util.HashSet;

public class ConjuntoADT<T> {

    private final Set<T> conjunto;

    public ConjuntoADT() {
        conjunto = new HashSet<>();
    }

    public int longitud() {
        return conjunto.size();
    }

    public boolean contiene(T elemento) {
        return conjunto.contains(elemento);
    }

    public void agregar(T elemento) {
        if (!conjunto.contains(elemento)) {
            conjunto.add(elemento);
        } else {
            System.out.println("El conjunto ya contiene " + elemento);
        }
    }

    public void eliminar(T elemento) {
        if (conjunto.contains(elemento)) {
            conjunto.remove(elemento);
        } else {
            System.out.println("El conjunto no contiene " + elemento);
        }
    }

    public boolean equals(ConjuntoADT<T> otroConjunto) {
        return conjunto.equals(otroConjunto.conjunto);
    }

    public boolean esSubConjunto(ConjuntoADT<T> otroConjunto) {
        return otroConjunto.conjunto.containsAll(conjunto);
    }

    public ConjuntoADT<T> union(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> union = new ConjuntoADT<>();
        union.conjunto.addAll(this.conjunto);
        union.conjunto.addAll(otroConjunto.conjunto);
        return union;
    }

    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> interseccion = new ConjuntoADT<>();
        interseccion.conjunto.addAll(this.conjunto);
        interseccion.conjunto.retainAll(otroConjunto.conjunto);
        return interseccion;
    }

    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> diferencia = new ConjuntoADT<>();
        diferencia.conjunto.addAll(this.conjunto);
        diferencia.conjunto.removeAll(otroConjunto.conjunto);
        return diferencia;
    }

    @Override
    public String toString() {
        return conjunto.toString();
    }

    public static void main(String[] args) {
        // Conjuntos de prueba
        ConjuntoADT<Integer> conjunto1 = new ConjuntoADT<>();
        ConjuntoADT<Integer> conjunto2 = new ConjuntoADT<>();

        // Agregar elementos al primer conjunto
        conjunto1.agregar(1);
        conjunto1.agregar(2);
        conjunto1.agregar(3);
        System.out.println("Conjunto 1: " + conjunto1);

        // Agregar elementos al segundo conjunto
        conjunto2.agregar(3);
        conjunto2.agregar(4);
        conjunto2.agregar(5);
        System.out.println("Conjunto 2: " + conjunto2);

        // Unión de los dos conjuntos
        ConjuntoADT<Integer> union = conjunto1.union(conjunto2);
        System.out.println("Unión de Conjunto 1 y Conjunto 2: " + union);

        // Intersección de los dos conjuntos
        ConjuntoADT<Integer> interseccion = conjunto1.interseccion(conjunto2);
        System.out.println("Intersección de Conjunto 1 y Conjunto 2: " + interseccion);

        // Diferencia de los dos conjuntos
        ConjuntoADT<Integer> diferencia = conjunto1.diferencia(conjunto2);
        System.out.println("Diferencia de Conjunto 1 y Conjunto 2: " + diferencia);

        // Verificar si conjunto1 es subconjunto de conjunto2
        boolean esSubConjunto = conjunto1.esSubConjunto(conjunto2);
        System.out.println("¿Conjunto 1 es subconjunto de Conjunto 2? " + esSubConjunto);

        // Eliminar un elemento del conjunto1
        conjunto1.eliminar(2);
        System.out.println("Conjunto 1 después de eliminar el 2: " + conjunto1);

        // Verificar si conjunto1 contiene un elemento
        boolean contieneElemento = conjunto1.contiene(3);
        System.out.println("¿Conjunto 1 contiene el 3? " + contieneElemento);
    }
}