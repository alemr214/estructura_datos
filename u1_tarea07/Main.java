package u1_tarea07;

import java.util.Scanner;

public class Main {
  // Memoria estatica y automatica
  public static float sumar(float numero1, float numero2) {
    // Memoria dinamica
    return numero1 + numero2;
  }

  // Memoria estatica y automatica
  public static float restar(float numero1, float numero2) {
    // Memoria dinamica
    return numero1 - numero2;
  }

  // Memoria estatica y automatica
  public static float dividir(float numero1, float numero2) {
    // Memoria dinamica
    return numero1 / numero2;
  }

  // Memoria estatica y automatica
  public static float multiplicar(float numero1, float numero2) {
    // Memoria dinamica
    return numero1 * numero2;
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    // Variables
    float numero1;
    // Memoria dinamica
    float numero2 = 0;
    int operacion;
    float resultadoTemporal;
    // Memoria dinamica
    int desicion = 1;
    // Ciclo que persiste
    while (desicion == 1) {
      System.out.println("Ingresa un numero: ");
      // Memoria dinamica
      numero1 = entrada.nextFloat();
      if (numero2 == 0) {
        System.out.println("Ingresa un numero: ");
        // Memoria dinamica
        numero2 = entrada.nextFloat();
      }
      System.out.println("Ingresa la opcion a operar\n1.-Suma\n2.-Resta\n3.-Division\n4.-Multiplicacion");
      // Memoria dinamica
      operacion = entrada.nextInt();
      switch (operacion) {
        case 1:
          resultadoTemporal = sumar(numero1, numero2);
          numero2 = resultadoTemporal;
          System.out.println("El resultado es: " + numero2);
          break;
        case 2:
          resultadoTemporal = restar(numero1, numero2);
          numero2 = resultadoTemporal;
          System.out.println("El resultado es: " + numero2);
          break;
        case 3:
          resultadoTemporal = dividir(numero1, numero2);
          numero2 = resultadoTemporal;
          System.out.println("El resultado es: " + numero2);
          break;
        case 4:
          resultadoTemporal = multiplicar(numero1, numero2);
          numero2 = resultadoTemporal;
          System.out.println("El resultado es: " + numero2);
          break;
        default:
          System.out.println("Error, opcion invalida");
          break;
      }
      System.out.println("Deseas realizar mas operaciones?\n1.-Si\n2.-No");
      // Memoria dinamica
      desicion = entrada.nextInt();
    }
    entrada.close();
  }
}
