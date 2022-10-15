package u1_tarea06;

public class ListaSimple {
  private Nodo primero;

  public ListaSimple() {
    primero = null;
  }

  public void insertarPrimero(int elemento) {
    Nodo nuevo = new Nodo(elemento, primero);
    primero = nuevo;
  }

  public void insertarFinal(int elemento) {
    Nodo nuevo = new Nodo(elemento, null);
    if (primero == null) {
      primero = nuevo;
    } else {
      Nodo actual = primero;
      while (actual.getSiguiente() != null) {
        actual = actual.getSiguiente();

      }
      actual.setSiguiente(nuevo);
    }
    System.out.println("Final");
  }

  public void borrar(int elem) {
    if (primero == null)
      System.out.println("lista vacía");
    else if (primero.getElemento() == elem) {
      primero = primero.getSiguiente();
    } else {
      Nodo actual = primero;
      while (actual.getSiguiente() != null && actual.getSiguiente().getElemento() != elem)
        actual = actual.getSiguiente();
      if (actual.getSiguiente() == null)
        System.out.println("elemento " + elem + " no esta en la lista");
      else {
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
      }
    }
  }

  public void listar() {
    Nodo actual = primero;
    while (actual.getSiguiente() != null) {
      System.out.println(actual.getElemento());
      actual = actual.getSiguiente();

    }
    System.out.println(actual.getElemento());
  }
}
