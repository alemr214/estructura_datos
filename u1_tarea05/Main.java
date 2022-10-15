package u1_tarea05;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static boolean estaVacia(ArrayList<Integer> cola) {
    if (!cola.isEmpty()) {
      return true;
    }
    return false;
  }

  // Va borrando los datos hasta que la cola se encuentre vacia
  public static ArrayList<Integer> remueveElementos(int iterador, int limitador, ArrayList<Integer> cola) {
    for (iterador = 0; iterador < limitador; iterador++) {
      if (estaVacia(cola)) {
        cola.remove(0);
      }
    }
    return cola;
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    // Creacion de la cola como objeto
    ArrayList<Integer> fifo = new ArrayList<Integer>();
    // Inicializa un iterador para el metodo
    int iterador = 0;
    // Crea un limitador para datos de la cola
    int limiteMaximo = 10;
    // Va llenando la cola con numeros aleatorios
    for (int i = 0; i < limiteMaximo; i++) {
      System.out.println("Ingresa un valor:");
      // Valores por teclado
      fifo.add(entrada.nextInt());
    }
    // Muestra la cola completa
    System.out.println("La cola es: " + fifo);
    // Hace uso de los metodos establecidos
    System.out.println(remueveElementos(iterador, limiteMaximo, fifo));
    entrada.close();
  }
}
