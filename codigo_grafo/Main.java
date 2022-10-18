package codigo_grafo;

public class Main {

  public static void main(String[] args) {
    Graph<String> graph = new Graph<String>();
    graph.addVertex("a");
    graph.addVertex("b");
    graph.addVertex("c");
    graph.addVertex("d");
    graph.addVertex("e");
    graph.addVertex("f");
    graph.addVertex("g");
    graph.addVertex("h");
    graph.addVertex("i");
    graph.addVertex("j");
    graph.addVertex("k");
    graph.addVertex("l");

    graph.addEdge("a", "b");
    graph.addEdge("a", "c");
    graph.addEdge("a", "d");

    System.out.println(graph.getAllVertices());
    System.out.println(graph.getNeighbors("c"));
  }
}
