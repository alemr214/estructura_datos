package proyecto_pila;

public class TwoStacks {
  int[] array;
  int size;
  int top1, top2;

  // Constructor
  TwoStacks(int size) {
    this.size = size;
    array = new int[size];
    top1 = size / 2 + 1;
    top2 = size / 2;
  }

  // Metodo para agregar a la primera pila
  void push1(int element) {

    // Agrega los elementos hasta que se llene
    if (top1 > 0) {
      top1--;
      array[top1] = element;
    } else {
      System.out.print("Stack Overflow"
          + " By element :" + element + "\n");
      return;
    }
  }

  // Metodo para agregar a la segunda pila
  void push2(int element) {

    // Agrega los elementos hasta que se llene
    if (top2 < size - 1) {
      top2++;
      array[top2] = element;
    } else {
      System.out.print("Stack Overflow"
          + " By element :" + element + "\n");
      return;
    }
  }

  // Elimina el elemento de la primera pila
  int pop1() {
    if (top1 <= size / 2) {
      int element = array[top1];
      top1++;
      return element;
    } else {
      System.out.print("Stack UnderFlow");
      System.exit(1);
    }
    return 0;
  }

  // Elimina el elemento de la segunda pila
  int pop2() {
    if (top2 >= size / 2 + 1) {
      int element = array[top2];
      top2--;
      return element;
    } else {
      System.out.print("Stack UnderFlow");
      System.exit(1);
    }
    return 1;
  }
}
