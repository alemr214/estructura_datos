package u1_tarea03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int[][][] array = new int[10][20][30];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        for (int k = 0; k < array[i][j].length; k++) {
          System.out.println("Ingresa el valor de la posicion [" + i + "][" + j + "][" + k + "]");
          array[i][j][k] = entrada.nextInt();
        }
      }
    }
    // Impresion
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        for (int k = 0; k < array[i][j].length; k++) {
          System.out.println("Valor de la posicion [" + i + "][" + j + "][" + k + "]: " + array[i][j][k]);
        }
      }
    }
    entrada.close();
  }
}
