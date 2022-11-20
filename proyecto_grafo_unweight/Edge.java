package proyecto_grafo_unweight;

public class Edge<T> {
  T verticeConectado;

  public Edge(T v) {
    this.verticeConectado = v;
  }

  public T getVertice() {
    return verticeConectado;
  }

  @Override
  public String toString() {
    return "(" + verticeConectado + ")";
  }
}