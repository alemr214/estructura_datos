package u2_tarea04;

import java.util.Scanner;

public class Main {
  public static double potencia(int base, int exponente) {
    if (exponente == 0) {
      return 1;
    } else if (exponente == 1) {
      return base;
    } else if (exponente < 0) {
      return potencia(base, exponente + 1) / base;
    } else {
      return base * potencia(base, exponente - 1);
    }
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa el valor de la base: ");
    int base = entrada.nextInt();
    System.out.println("Ingresa el valor del exponente: ");
    int exponente = entrada.nextInt();
    System.out.println(potencia(base, exponente));
    entrada.close();
  }
}
