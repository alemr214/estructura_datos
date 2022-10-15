package u1_tarea06;

public class Nodo {
  private int elemento;
  private Nodo siguiente;

  public Nodo(int elemento, Nodo siguiente) {
    this.elemento = elemento;
    this.siguiente = siguiente;
  }

  public int getElemento() {
    return elemento;
  }

  public Nodo getSiguiente() {
    return siguiente;
  }

  public void setElemento(int elemento) {
    this.elemento = elemento;
  }

  public void setSiguiente(Nodo siguiente) {
    this.siguiente = siguiente;
  }
}
