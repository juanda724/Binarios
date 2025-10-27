package co.edu.uniquindio.arbolBinario;

public class Tree<T extends Comparable<T>> {
    private Nodo<T> root;
    private int size;

    public Tree() {
        this.root = null;
        this.size = 0;
    }

    // 1. Insertar un elemento
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Nodo<T> insertRecursive(Nodo<T> current, T value) {
        if (current == null) {
            size++;
            return new Nodo<>(value);
        }

        int comparison = value.compareTo(current.getValue());
        if (comparison < 0) {
            current.setIzquierda(insertRecursive(current.getIzquierda(), value));
        } else if (comparison > 0) {
            current.setDerecha(insertRecursive(current.getDerecha(), value));
        }

        return current;
    }

    // 2. Buscar un elemento
    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Nodo<T> current, T value) {
        if (current == null) {
            return false;
        }

        int comparison = value.compareTo(current.getValue());
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return searchRecursive(current.getIzquierda(), value);
        } else {
            return searchRecursive(current.getDerecha(), value);
        }
    }

    // 3. Eliminar un elemento
    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private Nodo<T> deleteRecursive(Nodo<T> current, T value) {
        if (current == null) {
            return null;
        }

        int comparison = value.compareTo(current.getValue());
        if (comparison < 0) {
            current.setIzquierda(deleteRecursive(current.getIzquierda(), value));
        } else if (comparison > 0) {
            current.setDerecha(deleteRecursive(current.getDerecha(), value));
        } else {
            size--;

            // Caso 1: Nodo sin hijos (hoja)
            if (current.isLeaf()) {
                return null;
            }

            // Caso 2: Nodo con un solo hijo
            if (!current.hasIzquierda()) {
                return current.getDerecha();
            }
            if (!current.hasDerecha()) {
                return current.getIzquierda();
            }

            // Caso 3: Nodo con dos hijos
            // Encontrar el sucesor inorden (el menor en el subárbol derecho)
            T successorValue = findMinValue(current.getDerecha());
            current.setValue(successorValue);
            current.setDerecha(deleteRecursive(current.getDerecha(), successorValue));
        }

        return current;
    }

    // Método auxiliar para encontrar el valor mínimo
    private T findMinValue(Nodo<T> nodo) {
        while (nodo.hasIzquierda()) {
            nodo = nodo.getIzquierda();
        }
        return nodo.getValue();
    }

    // 4. Recorrido InOrder (izquierda, raíz, derecha)
    public void inOrder() {
        System.out.print("InOrder: ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Nodo<T> nodo) {
        if (nodo != null) {
            inOrderRecursive(nodo.getIzquierda());
            System.out.print(nodo.getValue() + " ");
            inOrderRecursive(nodo.getDerecha());
        }
    }

    // 5. Recorrido PreOrder (raíz, izquierda, derecha)
    public void preOrder() {
        System.out.print("PreOrder: ");
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValue() + " ");
            preOrderRecursive(nodo.getIzquierda());
            preOrderRecursive(nodo.getDerecha());
        }
    }

    // 6. Recorrido PostOrder (izquierda, derecha, raíz)
    public void postOrder() {
        System.out.print("PostOrder: ");
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Nodo<T> nodo) {
        if (nodo != null) {
            postOrderRecursive(nodo.getIzquierda());
            postOrderRecursive(nodo.getDerecha());
            System.out.print(nodo.getValue() + " ");
        }
    }

    // 7. Obtener la altura del árbol
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Nodo<T> nodo) {
        if (nodo == null) {
            return -1; // Altura de árbol vacío es -1
        }
        return 1 + Math.max(heightRecursive(nodo.getIzquierda()), heightRecursive(nodo.getDerecha()));
    }

    // 8. Verificar si el árbol está vacío
    public boolean isEmpty() {
        return root == null;
    }

    // 9. Obtener el tamaño del árbol
    public int size() {
        return size;
    }

    // 10. Encontrar el valor mínimo en el árbol
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("El árbol está vacío");
        }
        return findMinValue(root);
    }

    // 11. Encontrar el valor máximo en el árbol
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("El árbol está vacío");
        }
        Nodo<T> current = root;
        while (current.hasDerecha()) {
            current = current.getDerecha();
        }
        return current.getValue();
    }

    // 12. Limpiar el árbol
    public void clear() {
        root = null;
        size = 0;
    }

    // 13. Método para imprimir el árbol de forma visual 
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Árbol vacío");
            return;
        }
        printTreeRecursive(root, "", true);
    }

    private void printTreeRecursive(Nodo<T> nodo, String prefix, boolean isLast) {
        if (nodo != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + nodo.getValue());
            
            if (nodo.hasIzquierda() || nodo.hasDerecha()) {
                if (nodo.hasIzquierda()) {
                    printTreeRecursive(nodo.getIzquierda(), prefix + (isLast ? "    " : "│   "), !nodo.hasDerecha());
                }
                if (nodo.hasDerecha()) {
                    printTreeRecursive(nodo.getDerecha(), prefix + (isLast ? "    " : "│   "), true);
                }
            }
        }
    }
}

