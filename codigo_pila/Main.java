package codigo_pila;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Pila pila = new Pila();
    System.out.println("Trabajo con pila\n");
    System.out.println("Cuantos valores quiere ingresar en la pila?");
    int cantidadValores = entrada.nextInt();

    for (int i = 0; i < cantidadValores; i++) {
      System.out.println("Ingrese el valor: ");
      int valor = entrada.nextInt();
      pila.apilar(valor);
    }

    System.out.println("Datos de la pila");
    pila.listar();
    System.out.println("Tamaño de la pila");
    System.out.println(pila.getSize());

    System.out.println("Retira un valor de la pila");
    pila.retirar();
    System.out.println("Datos de la pila actualizados");
    pila.listar();
    System.out.println("Tamaño actualizado: " + pila.getSize());

    System.out.println("Cambia el valor del todo por otro nuevo");
    System.out.println("Ingresa el valor a cambiar");
    int valor = entrada.nextInt();
    System.out.println("Ingresa el nuevo valor");
    int valorNuevo = entrada.nextInt();
    pila.editar(valor, valorNuevo);
    pila.listar();
    System.out.println("Tamaño actualizado: " + pila.getSize());

    System.out.println("Elimina un valor en concreto:");
    valor = entrada.nextInt();
    pila.remover(valor);
    pila.listar();
    System.out.println("Tamaño actualizado: " + pila.getSize());

    System.out.println("Consulta si existe un valor");
    valor = entrada.nextInt();
    System.out.println(pila.buscar(valor));

    System.out.println("Elimina la pila completamente");
    pila.eliminar();

    System.out.println("Verifica si la pila esta vacia");
    System.out.println(pila.esVacia());
    entrada.close();
  }
}