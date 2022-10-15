package u2_tarea02;

import java.util.Scanner;

public class Main {
  public static void mostrarArrayRecursivo(int[] array, int indice) {

    if (indice != array.length) {
      System.out.println(array[indice]);
      mostrarArrayRecursivo(array, indice + 1);
    }
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa cuantos valores va a tener el arreglo: ");
    int limite = entrada.nextInt();
    int[] array = new int[limite];
    for (int i = 0; i < limite; i++) {
      array[i] = (int) (Math.random() * 10);
    }
    mostrarArrayRecursivo(array, 0);
    entrada.close();
  }
}
