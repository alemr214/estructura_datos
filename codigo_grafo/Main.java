package codigo_grafo;

public class Main {

  public static void main(String[] args) {
    Graph<String> graph = new Graph<String>();
    graph.addVertex("a");
    graph.addVertex("b");
    graph.addVertex("c");
    graph.addVertex("d");

    graph.addEdge("a", "b");
    graph.addEdge("a", "c");
    graph.addEdge("a", "d");

    System.out.println(graph.getAllVertices());
    System.out.println(graph.getNeighbors("c"));
  }
}
