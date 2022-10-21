package proyecto_grafo_unweight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Genera un grafo con un tipo de dato
public class Graph<T> {
  // Variable donde se almanceran los datos
  final private HashMap<T, Set<T>> adjacencyList;

  // Metodo constructor
  public Graph() {
    this.adjacencyList = new HashMap<>();
  }

  // Metodo que agrega un vertice
  public void addVertex(T v) {
    if (this.adjacencyList.containsKey(v)) {
      throw new IllegalArgumentException("Vertex already exists.");
    }
    this.adjacencyList.put(v, new HashSet<T>());
  }

  // Metodo que elimina un vertice
  public void removeVertex(T v) {
    if (!this.adjacencyList.containsKey(v)) {
      throw new IllegalArgumentException("Vertex doesn't exist.");
    }

    this.adjacencyList.remove(v);

    for (T u : this.getAllVertices()) {
      this.adjacencyList.get(u).remove(v);
    }
  }

  // Metodo que agrega las conexiones entre vertcies
  public void addEdge(T v, T u) {
    if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
      throw new IllegalArgumentException();
    }

    this.adjacencyList.get(v).add(u);
    this.adjacencyList.get(u).add(v);
  }

  // Metodo que remueve las conexiones entre vertices
  public void removeEdge(T v, T u) {
    if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
      throw new IllegalArgumentException();
    }

    this.adjacencyList.get(v).remove(u);
    this.adjacencyList.get(u).remove(v);
  }

  // Metodo que pregunta si vertices son adyacentes
  public boolean isAdjacent(T v, T u) {
    return this.adjacencyList.get(v).contains(u);
  }

  // Metodo que devuelve los vertices adyacentes
  public Iterable<T> getNeighbors(T v) {
    return this.adjacencyList.get(v);
  }

  // Metodo que devuelve todos los vertices del grafo
  public Iterable<T> getAllVertices() {
    return this.adjacencyList.keySet();
  }
}