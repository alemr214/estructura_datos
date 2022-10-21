package salim.lista_enlazada;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    Scanner scanner = new Scanner(System.in);
    int decision = 0, data = 0, index = 0, counter = 0;
    do {
      System.out.println(
          "Menu\n1. Agregar elementos\n2. Cantidad de elementos\n3. Ver elemenos\n4. Eliminar elemento\n5. Salir");
      decision = scanner.nextInt();
      switch (decision) {
        case 1:
          System.out.println("Ingresa el dato: ");
          data = scanner.nextInt();
          counter++;
          if (counter % 2 == 0) {
            list.addFirst(data);
          }
          list.addLast(data);
          break;
        case 2:
          System.out.println("La cantida de datos ingresada es: " + list.size());
          break;
        case 3:
          System.out.println("Los datos ingresados son: " + list);
          break;
        case 4:
          System.out.println("Ingrese la posicion del valor que quiere remover: ");
          index = scanner.nextInt();
          System.out.println("Se elimino el dato: " + list.remove(index));
          break;
        case 5:
          System.exit(0);
          break;
        default:
          System.out.println("Opcion incorrecta");
          System.exit(0);
          break;
      }
    } while (decision != 5);
    scanner.close();
  }
}
