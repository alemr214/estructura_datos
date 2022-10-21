package codigo_graph_weight;

import java.util.LinkedList;

public class Main {
  // Clase para la arista
  static class Edge {
    int source;
    int destination;
    int weight;

    // Constructor de la arista
    public Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }
  }

  // Clase para el grafo y sus nodos
  static class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencylist;

    // Constructor del grafo y sus nodos
    /**
     * @param vertices
     */
    Graph(int vertices) {
      this.vertices = vertices;
      adjacencylist = new LinkedList[vertices];
      // Inicia una lista de adyacencia para todos los vertices
      for (int i = 0; i < vertices; i++) {
        adjacencylist[i] = new LinkedList<>();
      }
    }

    // Metodo que conecta las aristas con sus valores
    public void addEgde(int source, int destination, int weight) {
      Edge edge = new Edge(source, destination, weight);
      adjacencylist[source].addFirst(edge); // Agrega las aristas directamente a los nodos
    }

    // Metodo muestra el grafo y las conexiones que tiene
    public void printGraph() {
      for (int i = 0; i < vertices; i++) {
        LinkedList<Edge> list = adjacencylist[i];
        for (int j = 0; j < list.size(); j++) {
          System.out.println("vertex-" + i + " is connected to " +
              list.get(j).destination + " with weight " + list.get(j).weight);
        }
      }
    }
  }

  public static void main(String[] args) {
    // Declara cuantos nodos se desean
    int vertices = 6;
    // Inicializa el grafo con el numero de vertices
    Graph graph = new Graph(vertices);
    // Nodos de los grafos y su peso
    graph.addEgde(0, 1, 4);
    graph.addEgde(0, 2, 3);
    graph.addEgde(1, 3, 2);
    graph.addEgde(1, 2, 5);
    graph.addEgde(2, 3, 7);
    graph.addEgde(3, 4, 2);
    graph.addEgde(4, 0, 4);
    graph.addEgde(4, 1, 4);
    graph.addEgde(4, 5, 6);
    // Imprime el grafo
    graph.printGraph();
  }
}
