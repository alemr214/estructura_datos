package codigo_pila;

public class Nodo {
  private int valor;
  private Nodo siguiente;

  public Nodo() {
    this.valor = 0;
    this.siguiente = null;
  }

  public int getValor() {
    return this.valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public Nodo getSiguiente() {
    return this.siguiente;
  }

  public void setSiguiente(Nodo siguiente) {
    this.siguiente = siguiente;
  }
}
