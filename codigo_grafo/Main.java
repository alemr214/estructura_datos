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
    graph.addEdge("b", "e");
    graph.addEdge("b", "f");
    graph.addEdge("b", "g");
    graph.addEdge("c", "h");
    graph.addEdge("c", "i");
    graph.addEdge("c", "j");
    graph.addEdge("k", "l");

    System.out.println(graph.getAllVertices());
    System.out.println(graph.getNeighbors("c"));
  }
}
