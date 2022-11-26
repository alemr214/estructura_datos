package proyecto_grafo_unweight;

import java.util.Scanner;

public class Main<T> {
  static Scanner scanner = new Scanner(System.in);

  public static void limpiarConsola() {
    String clean = "\033[H\033[2J";
    scanner.nextLine();
    System.out.println("\n\t\tteclee enter para continuar ");
    scanner.nextLine();
    System.out.println(clean);
  }

  public static void main(String[] args) {
    Graph<Integer> graph = new Graph<Integer>();
    int option = 0, source = 0, destiny = 0, a = 0;
    boolean flag = true;
    do {
      System.out.println(
          "--- Opciones ---\n1. Crear conexion\n2. Eliminar Conexion\n3. Checa si existe un nodo\n4. Imprime la lista de adyacencia\n5. Imprime lista de aristas\n6. Imprime Matriz de Adyacencia\n7. Salir");
      System.out.print("Ingrese su opcion: ");
      option = scanner.nextInt();

      switch (option) {
        case 1:
          System.out.print("Ingrese el valor del vertice que va a ingresar: ");
          source = scanner.nextInt();
          System.out.print("Ingrese el vertice con el cual estara conectado: ");
          destiny = scanner.nextInt();
          graph.addEdge(source, destiny);
          limpiarConsola();
          break;
        case 2:
          System.out.print("Ingrese el vertice fuente: ");
          source = scanner.nextInt();
          System.out.print("Ingrese el vertice destino: ");
          destiny = scanner.nextInt();

          graph.removeEdge(source, destiny);
          limpiarConsola();
          break;
        case 3:
          System.out.print("Ingrese el vertice que desea buscar: ");
          a = scanner.nextInt();
          System.out.println("El vertice existe: " + graph.hasNode(a));
          limpiarConsola();
          break;
        case 4:
          System.out.println("--- graph ---");
          graph.printAdyacencyList();
          limpiarConsola();
          break;
        case 5:
          System.out.println("--- LISTA DE ARISTAS ---");
          graph.printEdgelist();
          limpiarConsola();
          break;
        case 6:
          System.out.println("--- MATRIZ DE ADYACENCIA ---");
          graph.printAdyacencyMatrix();
          limpiarConsola();
          break;
        case 7:
          flag = false;
          break;
        default:
          System.out.println("Opcion incorrecta");
          System.exit(0);
          break;
      }
    } while (flag == true);
    scanner.close();
  }
}