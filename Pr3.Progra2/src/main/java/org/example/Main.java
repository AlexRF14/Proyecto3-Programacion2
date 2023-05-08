package org.example;
import org.example.Graph;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph<String> grafo = new Graph<String>();



        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Añadir vértice.");
            System.out.println("2. Añadir arista.");
            System.out.println("3. Obtener adyacentes.");
            System.out.println("4. Comprobar si existe un vértice.");
            System.out.println("5. Mostrar grafo.");
            System.out.println("6. Seguimiento de nodos ");
            System.out.println("7. Test ");
            System.out.println("0. Salir.");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del vértice:");
                    String vertice = scanner.next();
                    grafo.addVertex(vertice);
                    break;
                case 2:
                    System.out.println("Introduce el nombre del primer vértice:");
                    String vertice1 = scanner.next();
                    System.out.println("Introduce el nombre del segundo vértice:");
                    String vertice2 = scanner.next();
                    grafo.addEdge(vertice1, vertice2);
                    break;
                case 3:
                    System.out.println("Introduce el nombre del vértice:");
                    String verticeAdyacente = scanner.next();
                    try {
                        Set<String> adyacentes = grafo.obtainAdjacents(verticeAdyacente);
                        System.out.println("Los vértices adyacentes a " + verticeAdyacente + " son:");
                        for (String v : adyacentes) {
                            System.out.println(v);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nombre del vértice:");
                    String verticeComprobar = scanner.next();
                    if (grafo.containsVertex(verticeComprobar)) {
                        System.out.println("El vértice " + verticeComprobar + " existe en el grafo.");
                    } else {
                        System.out.println("El vértice " + verticeComprobar + " no existe en el grafo.");
                    }
                    break;
                case 5:
                    System.out.println("Grafo:");
                    System.out.println(grafo.toString());
                    break;
                case 6:
                    System.out.println("Introduce el nombre del primer vértice:");
                    String v1 = scanner.next();
                    System.out.println("Introduce el nombre del segundo vértice:");
                    String v2 = scanner.next();
                    grafo.onePath(v1, v2);
                    break;
               /* case 7:
                    grafo.onePathFindsAPath();
                    break;
*/
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

