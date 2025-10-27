package co.edu.uniquindio.arbolBinario;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Ejemplo \n");
        
        // Crear un árbol de enteros
        Tree<Integer> tree = new Tree<>();
        Random rand = new Random();
        
        // 1. Estado inicial
        System.out.println("1. Estado inicial del árbol:");
        System.out.println("Está vacío? " + tree.isEmpty());
        System.out.println("Tamaño: " + tree.size());
        System.out.println();
        
        // 2. Insertar 10 números aleatorios entre 1 y 100
        System.out.println("2. Insertando números aleatorios:");
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100) + 1;
            System.out.print(num + " ");
            tree.insert(num);
        }
        System.out.println("\nTamaño después de insertar: " + tree.size());
        System.out.println();
        
        // 3. Visualizar el árbol
        System.out.println("3. Estructura del árbol:");
        tree.printTree();
        System.out.println();
        
        // 4. Recorridos
        System.out.println("4. Recorridos del árbol:");
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();
        System.out.println();
        
        // 5. Buscar algunos elementos
        System.out.println("5. Búsquedas:");
        int[] busquedas = {10, 50, 75};
        for (int num : busquedas) {
            System.out.println("Existe " + num + "? " + tree.search(num));
        }
        System.out.println();
        
        // 6. Mínimo, máximo y altura
        System.out.println("6. Valores extremos y altura:");
        System.out.println("Valor mínimo: " + tree.findMin());
        System.out.println("Valor máximo: " + tree.findMax());
        System.out.println("Altura del árbol: " + tree.height());
        System.out.println();
        
        // 7. Eliminar algunos elementos
        System.out.println("7. Eliminaciones:");
        int[] eliminaciones = {busquedas[0], busquedas[1]};
        for (int num : eliminaciones) {
            System.out.println("Eliminando " + num + ":");
            tree.delete(num);
            System.out.println("Tamaño después: " + tree.size());
            tree.inOrder();
            System.out.println();
        }
        
        // 8. Árbol final
        System.out.println("8. Árbol final:");
        tree.printTree();
        System.out.println();
        
        // 9. Limpiar el árbol
        System.out.println("9. Limpiando el árbol:");
        tree.clear();
        System.out.println("Está vacío? " + tree.isEmpty());
        System.out.println("Tamaño: " + tree.size());
        
        System.out.println("\n FIN DEL EJEMPLO");
    }
}

