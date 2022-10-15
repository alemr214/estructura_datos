package u2_ejercicio02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa que numero quieres saber su factorial: ");
    int numero = entrada.nextInt();
    int factorial = 1;
    for (int i = numero; i > 0; i--) {
      factorial = factorial * i;
    }
    System.out.println(factorial);
    entrada.close();
  }
}
