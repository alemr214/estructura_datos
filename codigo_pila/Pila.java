package codigo_pila;

public class Pila {
  private Nodo inicio;
  private int size;

  public Pila() {
    inicio = null;
    size = 0;
  }

  public boolean esVacia() {
    return inicio == null;
  }

  public int getSize() {
    return size;
  }

  public void apilar(int valor) {
    Nodo nuevo = new Nodo();
    nuevo.setValor(valor);
    if (esVacia()) {
      inicio = nuevo;
    } else {
      nuevo.setSiguiente(inicio);
      inicio = nuevo;
    }
    size++;
  }

  public void retirar() {
    if (!esVacia()) {
      inicio = inicio.getSiguiente();
      size--;
    }
  }

  public int cima() throws Exception {
    if (!esVacia()) {
      return inicio.getValor();
    } else {
      throw new Exception("La pila esta vacia");
    }
  }

  public boolean buscar(int referencia) {
    Nodo auxiliar = inicio;
    boolean existe = false;
    while (!existe && auxiliar != null) {
      if (referencia == auxiliar.getValor()) {
        existe = true;
      } else {
        auxiliar = auxiliar.getSiguiente();
      }
    }
    return existe;
  }

  public void remover(int referencia) {
    if (buscar(referencia)) {
      Nodo pilaAuxiliar = null;
      while (referencia != inicio.getValor()) {
        Nodo temporal = new Nodo();
        temporal.setValor(inicio.getValor());
        if (pilaAuxiliar == null) {
          pilaAuxiliar = temporal;
        } else {
          temporal.setSiguiente(pilaAuxiliar);
          pilaAuxiliar = temporal;
        }
        retirar();
      }
      retirar();
      while (pilaAuxiliar != null) {
        apilar(pilaAuxiliar.getValor());
        pilaAuxiliar = pilaAuxiliar.getSiguiente();
      }
      pilaAuxiliar = null;
    }
  }

  public void editar(int referencia, int valor) {
    if (buscar(referencia)) {
      Nodo pilaAuxiliar = null;
      while (referencia != inicio.getValor()) {
        Nodo temporal = new Nodo();
        temporal.setValor(inicio.getValor());
        if (pilaAuxiliar == null) {
          pilaAuxiliar = temporal;
        } else {
          temporal.setSiguiente(pilaAuxiliar);
          pilaAuxiliar = temporal;
        }
        retirar();
      }
      inicio.setValor(valor);
      while (pilaAuxiliar != null) {
        apilar(pilaAuxiliar.getValor());
        pilaAuxiliar = pilaAuxiliar.getSiguiente();
      }
      pilaAuxiliar = null;
    }
  }

  public void eliminar() {
    inicio = null;
    size = 0;
  }

  public void listar() {
    Nodo auxiliar = inicio;
    while (auxiliar != null) {
      System.out.println(auxiliar.getValor());
      auxiliar = auxiliar.getSiguiente();
    }
  }
}
