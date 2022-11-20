package proyecto_grafo_unweight;

import java.util.*;

public class Graph<T> {
  Map<T, LinkedList<Edge<T>>> adyacencylist;
  boolean dirigido;

  public Graph() {
    adyacencylist = new HashMap<>();
  }

  /**
   * @param source  Nodo fuente
   * @param destiny Nodo al que se encontrara conectada la fuente
   * @param T       Indica que la clase puede ser generica
   */

  public void addEdge(T source, T destiny) {
    adyacencylist.putIfAbsent(source, new LinkedList<>()); // Agrega el nodo de origen
    adyacencylist.putIfAbsent(destiny, new LinkedList<>()); // Agrega el nodo al cual estara conectado
    Edge<T> edge1 = new Edge<>(destiny);
    adyacencylist.get(source).add(edge1); // Agrega la arista
  }

  /**
   * Metodo auxiliar que encuentra una arista entre dos nodos
   * 
   * @param source  Indica el nodo fuente a partir del cual se realizara la
   *                busqueda
   * @param destiny Indica el nodo al cual se encuentra conectada la fuente
   * @return Devolvera el objeto vertice en caso de ser encontrado
   */

  private Edge<T> findEdgeByVertice(T source, T destiny) {
    LinkedList<Edge<T>> listAux = adyacencylist.get(source);
    for (Edge<T> edge : listAux) {
      if (edge.verticeConectado.equals(destiny))
        return edge;
    }
    return null;
  }

  /**
   * Elimina la conexion directa entre dos nodos
   * 
   * @param source  Indica el nodo fuente
   * @param destiny Indica el con el cual se eliminara la conexion
   */

  public void removeEdge(T source, T destiny) {
    LinkedList<Edge<T>> auxSource = adyacencylist.get(source);
    LinkedList<Edge<T>> auxTarget = adyacencylist.get(destiny);
    if (auxSource == null || auxTarget == null) {
      System.out.println("No existe esa conexion");
      return;
    }
    Edge<T> edge1 = findEdgeByVertice(source, destiny);
    auxSource.remove(edge1);
  }

  /**
   * Verifica si un nodo existe
   * 
   * @param key Valor que tiene el nodo
   * @return existe o no
   */

  public boolean hasNode(T key) {
    return adyacencylist.containsKey(key);
  }

  /**
   * Verifica si es que existe una conexion directa entre dos nodos
   * 
   * @param a Nodo fuente
   * @param b Nodo objetivo sobre el cual se verificara si existe la conexion
   * @return valor booleano dependiendo de si existe o no la conexion con el nodo
   */
  public boolean hasEdge(T a, T b) {
    Edge<T> edge1 = findEdgeByVertice(a, b);
    return edge1 != null;
  }

  // Imprime el grafo
  public void printAdyacencyList() {
    for (T key : adyacencylist.keySet()) {
      System.out.println(key + " -> " + adyacencylist.get(key));
    }
  }

  // Imprime la lista de aristas
  public void printEdgelist() {
    for (T key : adyacencylist.keySet()) {
      LinkedList<Edge<T>> listaux = adyacencylist.get(key);
      for (Edge<T> edge : listaux) {
        System.out.print("( " + key + " , " + edge.getVertice() + " ) ");
      }
    }
    System.out.println();
  }

  // Imprime la matriz de adyacencia
  public void printAdyacencyMatrix() {
    System.out.print("   ");
    for (T key : adyacencylist.keySet()) {
      System.out.print(" " + key + " ");
    }
    System.out.println();
    System.out.println("   ---------------------------");
    for (T key : adyacencylist.keySet()) {
      System.out.print(key + "| ");
      for (T key2 : adyacencylist.keySet()) {
        if (hasEdge(key, key2)) {
          System.out.print(" 1 ");
        } else {
          System.out.print(" 0 ");
        }
      }
      System.out.println();
    }
  }
}