package proyecto_lista;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Variable para entrada de datos
    Scanner scanner = new Scanner(System.in);
    // Creacion de la lista doble
    LinkedList<Integer> primes = new LinkedList<Integer>();
    LinkedList<Integer> droped = new LinkedList<Integer>();
    // Variables iniciales
    int decison = 0, size = 0, number = 0, counter = 0;
    boolean isPrime = true;
    do {
      // Menu de opciones
      System.out
          .println(
              "Menu de aplicacion\n1. Ingresa un numero y prueba tus conocimientos\n2. Checa la cantidad de numeros que hay en la lista\n3. Salir");
      decison = scanner.nextInt();
      switch (decison) {
        case 1:
          System.out.println("Ingrese cuantos alumnos hay:");
          // Cantidad de datos
          size = scanner.nextInt();
          for (int i = 1; i <= size; i++) {
            System.out.println("Ingrese un numero");
            // Numeros
            number = scanner.nextInt();
            for (int j = 2; j < number; j++) {
              if (number % j == 0) {
                isPrime = false;
                break;
              }
            }
            if (isPrime) {
              System.out.println("Bien, el numero " + number + " es primo");
              // Guarda elementos
              primes.addLast(number);
            } else {
              System.out.println("Mal, el numero " + number + " no es primo, se eliminara un registro");
              // Contador
              counter++;
            }
          }
          if (primes.size() != 0) {
            for (int i = 0; i < counter; i++) {
              // Eliminacion de elementos y guardado en otra lista
              droped.add(primes.removeFirst());
            }
          } else {
            System.out.println("No ingresaron ningun numero primo");
          }
          break;
        case 2:
          System.out.println("Existen: " + primes.size() + " numeros primos ingresados");
          break;
        case 3:
          System.out.println("La lista quedo como: " + primes);
          System.out.println("Los primos que se eliminaron fueron: " + droped);
          System.out.println("Se ganaron " + primes.size() + " puntos para el grupo");
          System.exit(0);
          break;
        default:
          System.out.println("Opcion invalido");
          System.exit(0);
          break;
      }
    } while (decison != 3);
    scanner.close();
  }
}
