package co.edu.uniquindio.arbolBinario;

public class Nodo<T> {
    T value;
    Nodo<T> izquierda;
    Nodo<T> derecha;

    // Constructores
    public Nodo() {
        this.value = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public Nodo(T value) {
        this.value = value;
        this.izquierda = null;
        this.derecha = null;
    }

    public Nodo(T value, Nodo<T> izquierda, Nodo<T> derecha) {
        this.value = value;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    // Getters y Setters para value
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    // Getters y Setters para izquierda
    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    // Getters y Setters para derecha
    public Nodo<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }

    // Verificar si es una hoja
    public boolean isLeaf() {
        return izquierda == null && derecha == null;
    }

    // Verificar si tiene hijo izquierdo
    public boolean hasIzquierda() {
        return izquierda != null;
    }

    // Verificar si tiene hijo derecho
    public boolean hasDerecha() {
        return derecha != null;
    }

    @Override
    public String toString() {
        return value != null ? value.toString() : "null";
    }
}

