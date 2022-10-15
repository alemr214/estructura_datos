package u1_ejercicio_practica01;

import java.util.Scanner;

//Hacer una calculadora que ingrese los números por teclado debe aceptar, valores decimales y números negativos
public class Main {
  // Metodos operacionales
  public static float sumar(float numero1, float numero2) {
    return numero1 + numero2;
  }

  public static float restar(float numero1, float numero2) {
    return numero1 - numero2;
  }

  public static float dividir(float numero1, float numero2) {
    return numero1 / numero2;
  }

  public static float multiplicar(float numero1, float numero2) {
    return numero1 * numero2;
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    // Variables
    float numero1 = 0;
    float numero2 = 0;
    int operacion = 0;
    float resultadoTemporal = 0;
    int desicion = 1;
    // Ciclo que persiste
    while (desicion == 1) {
      System.out.println("Ingresa un numero: ");
      numero1 = entrada.nextFloat();
      if (numero2 == 0) {
        System.out.println("Ingresa un numero: ");
        numero2 = entrada.nextFloat();
      }
      System.out.println("Ingresa la opcion a operar\n1.-Suma\n2.-Resta\n3.-Division\n4.-Multiplicacion");
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
      desicion = entrada.nextInt();
    }
    entrada.close();
  }
}