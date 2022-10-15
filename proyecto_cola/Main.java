package proyecto_cola;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Variable para entrada de datos
    Scanner scanner = new Scanner(System.in);
    // Creacion de la cola doble
    Deque<Integer> deque = new ArrayDeque<Integer>();
    // Variables iniciales
    int decison = 0, size = 0, data = 0;
    do {
      // Menu de opciones
      System.out
          .println(
              "Menu de aplicacion\n1. Agregar los elementos\n2. Eliminar los elemenos desde la cabecera\n3. Eliminar elementos desde la cola\n4. Conocer el tamanio\n5. Imprimir los elementos actuales\n6. Salir");
      // Variable de ruta
      decison = scanner.nextInt();
      switch (decison) {
        case 1:
          System.out.println("Ingrese cuantos elementos va ingresar: ");
          // Cantidad de elementos
          size = scanner.nextInt();
          for (int i = 0; i < size; i++) {
            System.out.println("Ingrese el elemento");
            // Elemento
            data = scanner.nextInt();
            // Condicion filtro
            if (data % 2 == 0) {
              deque.addFirst(data);
            } else {
              deque.addLast(data);
            }
          }
          break;
        case 2:
          System.out.println("Ingrese cuantos datos quiere eliminar?:");
          // Cantidad de elementos
          size = scanner.nextInt();
          if (size <= deque.size() && size >= 0) {
            for (int i = 0; i < size; i++) {
              // Eliminacion de elementos
              deque.removeFirst();
            }
          } else {
            System.out.println("Cantidad fuera de rango, ingrese una nueva");
          }
          break;
        case 3:
          System.out.println("Ingrese cuantos datos quiere eliminar?:");
          // Cantidad de elementos
          size = scanner.nextInt();
          if (size <= deque.size() && size >= 0) {
            for (int i = 0; i < size; i++) {
              // Eliminacion de elementos
              deque.removeLast();
            }
          } else {
            System.out.println("Cantidad fuera de rango, ingrese una nueva");
          }
          break;
        case 4:
          System.out.println("El numero de elementos actual es: " + deque.size());
          break;
        case 5:
          System.out.println("Los datos actuales son: " + deque);
          break;
        case 6:
          System.exit(0);
          break;
        default:
          System.out.println("Opcion invalido");
          System.exit(0);
          break;
      }
    } while (decison != 6);
    scanner.close();
  }
}
