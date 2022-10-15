package u1_tarea04;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> pila = new Stack<Integer>();
    Scanner entrada = new Scanner(System.in);
    System.out.println("Cuantos valores almacena la pila?: ");
    int cantidadValores = entrada.nextInt();
    for (int i = 0; i < cantidadValores; i++) {
      System.out.println("Ingresa el valor de la pila");
      int valorPila = entrada.nextInt();
      pila.push(valorPila);
    }

    System.out.println("Los valores de la pila son: " + pila);
    // Vaciando la pila
    while (!pila.empty()) {
      pila.pop();
    }

    System.out.println("La pila esta vacia: " + pila);
    entrada.close();
  }
}
