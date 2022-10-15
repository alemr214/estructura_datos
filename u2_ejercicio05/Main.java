package u2_ejercicio05;

import java.util.Scanner;

public class Main {
  public static boolean esPalindromo(String texto) {
    if (texto.length() <= 1) {
      return true;
    } else {
      if (texto.charAt(0) == texto.charAt(texto.length() - 1)) {
        return esPalindromo(texto.substring(1, texto.length() - 1));
      } else {
        return false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa la oracion para verificar si es palindromo: ");
    String texto = entrada.next();
    texto = texto.replaceAll(" ", "");
    System.out.println(esPalindromo(texto));
    entrada.close();
  }
}
