package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        private T valor;
        private Nodo siguiente;
        private Nodo anterior;

        public Nodo(T valor){
            this.valor = valor;
            this.siguiente = null;
            this.anterior = null;
        }

    }

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (this.longitud == 0){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        }
        else {
            nuevoNodo.siguiente = this.primero;
            this.primero.anterior = nuevoNodo;
            this.primero = nuevoNodo;
        }
        this.longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (this.longitud == 0){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        }
        else {
            nuevoNodo.anterior = this.ultimo;
            this.ultimo.siguiente = nuevoNodo;
            this.ultimo = nuevoNodo;
        }
        this.longitud++;
    }

    public T obtener(int i) {
        ListaIterador it = new ListaIterador();
        if (i == 0) return this.primero.valor;
        for (int index = 0; index < i-1; index++){
            it.siguiente();
        }
        return it.siguiente();
    }

    public void eliminar(int i) {
        Nodo matchingNodo = this.primero;
        for (int index = 0; index < i; index++){
            matchingNodo = matchingNodo.siguiente;
        }
        if (matchingNodo.anterior != null){
            matchingNodo.siguiente.anterior = matchingNodo.anterior;  
        }
        else matchingNodo.siguiente.anterior = null; 
        
        if (matchingNodo.siguiente != null){
            matchingNodo.anterior.siguiente = matchingNodo.siguiente;    
        }
        else matchingNodo.anterior.siguiente = null;

        this.longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
        private Nodo nodo;

        public ListaIterador(){
            this.nodo = new Nodo(primero.valor);
            this.nodo.siguiente = primero.siguiente;
        }

        public boolean haySiguiente() {
	        return !(this.nodo.siguiente != null);
        }
        
        public boolean hayAnterior() {
	        return !(this.nodo.anterior != null);
        }

        public T siguiente() {
            T value = this.nodo.siguiente.valor;
            Nodo siguiente = this.nodo.siguiente.siguiente;
            Nodo anterior = this.nodo;
            this.nodo = new Nodo(value);
            this.nodo.siguiente = siguiente;
            this.nodo.anterior = anterior;
            return value;
        }
        

        public T anterior() {
            T value = this.nodo.anterior.valor;
            this.nodo = this.nodo.anterior;
            return value;
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
