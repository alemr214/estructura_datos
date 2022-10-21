package codigo_ordenamiento;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int[] arreglito = new int[15];
    for (int i = 0; i < 15; i++) {
      System.out.println("Ingrese un valor numerico entero: ");
      int valorUsuario = entrada.nextInt();
      arreglito[i] = valorUsuario;
    }
    System.out.println("Arreglo orignal: " + Arrays.toString(arreglito));
    for (int i = 0; i < arreglito.length - 1; i++) {
      for (int j = 0; j < arreglito.length - i - 1; j++) {
        if (arreglito[j] > arreglito[j + 1]) {
          // swap arr[j+1] and arr[j]
          int temp = arreglito[j];
          arreglito[j] = arreglito[j + 1];
          arreglito[j + 1] = temp;
        }
      }
    }
    System.out.println("Arreglo ordenado: " + Arrays.toString(arreglito));
    entrada.close();
  }
}
