package u2_tarea01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static ArrayList<Integer> primos = new ArrayList<Integer>();

  public static boolean esPrimo(int numero) {
    for (int i = 2; i < numero; i++) {
      if (numero % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean calcularCantidadPrimos(int a, int b) {
    if (a < 2 || b < 2) {
      System.out.println("Deben de ser mayores a 1");
      return false;
    }
    if (esPrimo(a)) {
      primos.add(a);
    }
    if (a == b) {
      System.out.println("Hemos encontrado primos: " + primos.size());
      System.out.println(primos);
      return false;
    }
    calcularCantidadPrimos(a + 1, b);
    return true;

  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese por el valor en que se quiera empezar a buscar los numeros primos: ");
    int limiteInferior = entrada.nextInt();
    System.out.println("Ingrese el limite");
    int limiteSuperior = entrada.nextInt();
    calcularCantidadPrimos(limiteInferior, limiteSuperior);
    entrada.close();
  }
}
