package u1_tarea01;

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
    System.out.println(Arrays.toString(arreglito));
    entrada.close();
  }
}
