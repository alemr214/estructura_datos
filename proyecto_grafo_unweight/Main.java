package proyecto_grafo_unweight;

public class Main {

  public static void main(String[] args) {
    Graph<Integer> graph = new Graph<Integer>();
    // graph.addVertex("a");
    // graph.addVertex("b");
    // graph.addVertex("c");
    // graph.addVertex("d");
    // graph.addVertex("e");
    // graph.addVertex("f");
    // graph.addVertex("g");
    // graph.addVertex("h");
    // graph.addVertex("i");
    // graph.addVertex("j");
    // graph.addVertex("k");
    // graph.addVertex("l");

    // graph.addEdge("a", "b");
    // graph.addEdge("a", "c");
    // graph.addEdge("a", "d");
    // graph.addEdge("b", "e");
    // graph.addEdge("b", "f");
    // graph.addEdge("b", "g");
    // graph.addEdge("c", "h");
    // graph.addEdge("c", "i");
    // graph.addEdge("c", "j");
    // graph.addEdge("k", "l");

    graph.addVertex(0);
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);
    graph.addVertex(6);
    graph.addVertex(7);
    graph.addVertex(8);
    graph.addVertex(9);

    graph.addEdge(0, 1);
    graph.addEdge(0, 8);
    graph.addEdge(0, 6);
    graph.addEdge(1, 4);
    graph.addEdge(1, 9);
    graph.addEdge(1, 6);
    graph.addEdge(2, 4);
    graph.addEdge(2, 6);
    graph.addEdge(3, 8);
    graph.addEdge(3, 5);
    graph.addEdge(3, 4);
    graph.addEdge(4, 9);
    graph.addEdge(4, 5);
    graph.addEdge(7, 9);
    graph.addEdge(7, 8);

    for (int i = 0; i < 9; i++) {
      System.out.println(graph.getNeighbors(i));
    }
  }
}
