package org.example;

import java.util.*;

public class Graph<V>{
    //Lista de adyacencia.
    public Map<V, Set<V>> adjacencyList = new HashMap<>();
    /******************************************************************
     * Añade el vértice ‘v‘ al grafo.
     *
     * @param v vértice a añadir.
     * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso

     * contrario.
     ******************************************************************/
    public boolean addVertex(V v){
        if(adjacencyList.containsKey(v)){
            return false;}
        else{
            adjacencyList.put(v, new HashSet<>());
            return true;
        }

        //Este código hay que modificarlo.
    }
    /******************************************************************
     * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo. En
     * caso de que no exista alguno de los vértices, lo añade
     * también.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return ‘true‘ si no existía el arco y ‘false‘ en caso
    contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2){
        if(adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)){
            adjacencyList.get(v1).add(v2);
            return true;
        }
        else{
            adjacencyList.put(v1, new HashSet<>());
            adjacencyList.put(v2, new HashSet<>());
            adjacencyList.get(v1).add(v2);
            return true;
        }

    }
    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a ‘v‘.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception {
        Set<V> connections = adjacencyList.get(v);
        if (connections == null) {
            throw new Exception("Error: El vertice no existe");
        }else{

            for (V v1 : connections) {
                System.out.println(v1);
                // Hacer algo con el vértice adyacente v
            }
        }
        return connections;
    }
    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return ‘true‘ si ‘v‘ es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v){
        if(adjacencyList.containsKey(v)){
            return true;}
        else{
            return false;
        }

    }
    /******************************************************************
     * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
     * @return una cadena de caracteres con la lista de
     * adyacencia.
     ******************************************************************/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grafo:\n");
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(": ");
            Set<V> connections = entry.getValue();
            for (V connection : connections) {
                sb.append(connection).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /*********************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y
     * ‘v2‘. En caso contrario, devuelve ‘null‘.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta
     * ‘v2‘ * pasando por arcos del grafo.
     *********************************************************/
    public List<V> onePath(V v1, V v2){
        Map<V, V> trace = new HashMap<>();
        Stack<V> open = new Stack<>();

        boolean encontrado = false;

        open.push(v1);
        trace.put(v1, null);

        while (!open.isEmpty()){
            V v = open.pop();
            encontrado = v.equals(v2);
            if((!encontrado)){
                try{for(V s : obtainAdjacents(v)){
                    open.push(s);
                    trace.put( s , v );
                }
                }catch (Exception e){
                    System.out.println("Error: El vertice no existe");
                }
            }
        }
        if(encontrado){
            List<V> path = new ArrayList<>();
            V actual = v2;

            while (actual != null) {
                path.add(0, actual);
                actual = trace.get(actual);
            }

            return path;
        }else {
            return null;
        }
    }
    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘
     * encuentra un camino entre ‘v1‘ y ‘v2‘ cuando existe.
     */

    public void onePathFindsAPath(){
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");
// Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
// Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
//Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }
    private void assertEquals(List<Integer> expectedPath, List<Integer> onePath) {
    }
    /*
     * import java.util.*;

public class Grafo {
    private Map<Integer, List<Integer>> adyacencias;

    public Grafo(Map<Integer, List<Integer>> adyacencias) {
        this.adyacencias = adyacencias;
    }

    public List<Integer> buscarCamino(int v1, int v2) {
        Map<Integer, Integer> traza = new HashMap<>();
        Deque<Integer> abierta = new ArrayDeque<>();
        abierta.push(v1);
        traza.put(v1, null);
        boolean encontrado = false;

        while (!abierta.isEmpty() && !encontrado) {
            int v = abierta.pop();
            encontrado = (v == v2);

            if (!encontrado) {
                for (int s : adyacencias.get(v)) {
                    if (!traza.containsKey(s)) {
                        abierta.push(s);
                        traza.put(s, v);
                    }
                }
            }
        }

        if (encontrado) {
            List<Integer> camino = new ArrayList<>();
            int v = v2;
            while (v != v1) {
                camino.add(0, v);
                v = traza.get(v);
            }
            camino.add(0, v1);
            return camino;
        } else {
            return null;
        }
    }



     */

}






