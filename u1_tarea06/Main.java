package u1_tarea06;

public class Main {
  public static void main(String args[]) {
    System.out.println("Comenzamos");
    ListaSimple listaSimple = new ListaSimple();
    listaSimple.insertarPrimero(2);
    listaSimple.insertarPrimero(1);
    listaSimple.insertarFinal(3);
    listaSimple.insertarFinal(4);

    System.out.println("Listamos desde main");
    listaSimple.listar();
    System.out.println("Borramos un Elemento");
    listaSimple.borrar(5);
    System.out.println("volvemos a listar");
    listaSimple.listar();
  }
}
