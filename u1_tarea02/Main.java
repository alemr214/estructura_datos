package u1_tarea02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int[][] array = new int[10][20];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        System.out.println("Ingrese valores enteros para la posicion " + i + " , " + j);
        array[i][j] = entrada.nextInt();
      }
    }

    // Impresion
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " "); // Imprime elemento
      }
      System.out.println(); // Imprime salto de línea
    }
    entrada.close();
  }
}
