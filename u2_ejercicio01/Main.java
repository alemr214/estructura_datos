package u2_ejercicio01;

import java.util.Scanner;

public class Main {
  public static int crearSerieFibonacci(int numero) {
    if (numero < 2) {
      return numero;
    } else {
      return crearSerieFibonacci(numero - 1) + crearSerieFibonacci(numero - 2);
    }
  }

  public static void main(String args[]) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa cuantos valoers quieres que se impriman de la serie de crearSerieFibonacci:");
    int base = entrada.nextInt();
    for (int i = 0; i < base; i++) {
      System.out.println(crearSerieFibonacci(i));
    }
    entrada.close();
  }
}
