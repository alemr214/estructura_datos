package u2_ejercicio04;

import java.util.Scanner;

public class Main {
  public static boolean esPrimo(int numero) {
    int contador = 2;
    boolean primo = true;
    while ((primo) && (contador != numero)) {
      if (numero % contador == 0) {
        primo = false;
      }
      if (numero == 1) {
        primo = true;
        return primo;
      }
      contador++;
    }
    return primo;
  }

  public static void FactoresPrimos(int n) {
    if (esPrimo(n)) {
      System.out.print("*" + n + " ");
      return;
    }
    int factor1 = (int) Math.sqrt(n);
    while (n % factor1 != 0) {
      factor1++;
    }
    FactoresPrimos(factor1);
    FactoresPrimos(n / factor1);

  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese un numero");
    int m = entrada.nextInt();
    System.out.println("Los factores primo son:");
    FactoresPrimos(m);
    System.out.println("\n");
    entrada.close();
  }

}
