package u2_ejercicio03;

import java.util.Scanner;

public class Main {
  public static void convertirDecimalBinario(int numero) {
    if (numero < 2) {
      System.out.print(numero);
    } else {
      convertirDecimalBinario(numero / 2);
      System.out.print(numero % 2);
    }
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa el numero para transformar en binario");
    int numero = entrada.nextInt();
    convertirDecimalBinario(numero);
    entrada.close();
  }
}
