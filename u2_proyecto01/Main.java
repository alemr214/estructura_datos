package u2_proyecto01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Buscaminas extends JFrame implements ActionListener {
  JButton[][] cuadricula;
  JButton botonReiniciar;

  Buscaminas() {
    setLayout(null);
    // Se genera una cuadricula de 10 x 10, usando botones como objeto visual
    cuadricula = new JButton[10][10];
    for (int fila = 0; fila < 10; fila++) {
      for (int columna = 0; columna < 10; columna++) {
        cuadricula[fila][columna] = new JButton("0");
        // Se le da dimensiones a los botones
        cuadricula[fila][columna].setBounds(20 + columna * 41, 50 + fila * 41, 41, 41);
        // Se les asigna un color a los botones
        cuadricula[fila][columna].setBackground(Color.lightGray);
        // Se le asigna un color a los numeros de fondo
        cuadricula[fila][columna].setForeground(Color.lightGray);
        cuadricula[fila][columna].addActionListener(this);
        add(cuadricula[fila][columna]);
      }
    }
    // Se crea un boton para reiniciar el juego
    botonReiniciar = new JButton("Reiniciar");
    // Se le da dimension al boton reiniciar
    botonReiniciar.setBounds(20, 470, 100, 30);
    add(botonReiniciar);
    botonReiniciar.addActionListener(this);
    disponerBombas();
    contarBombasPerimetro();
  }

  // Metodo para generar las bombas
  void disponerBombas() {
    // Cantidad fija de bombas totales por cada juego
    int cantidad = 10;
    // Pone la cantidad de bombas de manera aleatoria por cada fila y columna
    do {
      int fila = (int) (Math.random() * 10);
      int columna = (int) (Math.random() * 10);
      if (!cuadricula[fila][columna].getText().equals("b")) {
        cuadricula[fila][columna].setText("b");
        cantidad--;
      }
    } while (cantidad != 0);
  }

  // Metodo para contar cuantas bombas existen en el primetro de la cuadricula
  void contarBombasPerimetro() {
    for (int fila = 0; fila < 10; fila++) {
      for (int columna = 0; columna < 10; columna++) {
        if (cuadricula[fila][columna].getText().equals("0")) {
          int cant = contarCoordenada(fila, columna);
          cuadricula[fila][columna].setText(String.valueOf(cant));
        }
      }
    }
  }

  //
  int contarCoordenada(int fila, int columna) {
    int total = 0;
    if (fila - 1 >= 0 && columna - 1 >= 0) {
      if (cuadricula[fila - 1][columna - 1].getText().equals("b"))
        total++;
    }
    if (fila - 1 >= 0) {
      if (cuadricula[fila - 1][columna].getText().equals("b"))
        total++;
    }
    if (fila - 1 >= 0 && columna + 1 < 10) {
      if (cuadricula[fila - 1][columna + 1].getText().equals("b"))
        total++;
    }
    if (columna + 1 < 10) {
      if (cuadricula[fila][columna + 1].getText().equals("b"))
        total++;
    }
    if (fila + 1 < 10 && columna + 1 < 10) {
      if (cuadricula[fila + 1][columna + 1].getText().equals("b"))
        total++;
    }
    if (fila + 1 < 10) {
      if (cuadricula[fila + 1][columna].getText().equals("b"))
        total++;
    }
    if (fila + 1 < 10 && columna - 1 >= 0) {
      if (cuadricula[fila + 1][columna - 1].getText().equals("b"))
        total++;
    }
    if (columna - 1 >= 0) {
      if (cuadricula[fila][columna - 1].getText().equals("b"))
        total++;
    }
    return total;
  }

  // Metodo que desactiva cualquier movimiento
  void desactivarJuego() {
    for (int fila = 0; fila < 10; fila++) {
      for (int columna = 0; columna < 10; columna++) {
        cuadricula[fila][columna].setEnabled(false);
      }
    }
  }

  // Metodo para reiniciar el juego
  void reiniciar() {
    // Borra el titulo de la ventana
    setTitle("");
    // Cambia los valores de las filas y columnas
    for (int fila = 0; fila < 10; fila++) {
      for (int columna = 0; columna < 10; columna++) {
        cuadricula[fila][columna].setText("0");
        cuadricula[fila][columna].setEnabled(true);
        cuadricula[fila][columna].setBackground(Color.lightGray);
        cuadricula[fila][columna].setForeground(Color.lightGray);
      }
    }
    disponerBombas();
    contarBombasPerimetro();
  }

  // Metodo que comprueba los eventos que ocurren
  public void actionPerformed(ActionEvent e) {
    // Verifica si se presiono al boton reiniciar
    if (e.getSource() == botonReiniciar) {
      reiniciar();
    }
    for (int f = 0; f < 10; f++) {
      for (int c = 0; c < 10; c++) {
        if (e.getSource() == cuadricula[f][c]) {
          // Checa si se presiono sobre una bomba
          if (cuadricula[f][c].getText().equals("b")) {
            // Si explota una bomba se genera este titulo en la ventana
            setTitle("Boooooooooooooomm");
            // Ya no permite mas movimientos
            desactivarJuego();
          }
          // Verifican los valores dados una vez se pulsa sobre un recuadro
          else if (cuadricula[f][c].getText().equals("0")) {
            recorrer(f, c);
          } else if (cuadricula[f][c].getText().equals("1") ||
              cuadricula[f][c].getText().equals("2") ||
              cuadricula[f][c].getText().equals("3") ||
              cuadricula[f][c].getText().equals("4") ||
              cuadricula[f][c].getText().equals("5") ||
              cuadricula[f][c].getText().equals("6") ||
              cuadricula[f][c].getText().equals("7") ||
              cuadricula[f][c].getText().equals("8")) {
            // Cambia el color de los cuadros si este no es una bomba
            cuadricula[f][c].setBackground(Color.yellow);
            cuadricula[f][c].setForeground(Color.black);
          }
        }
      }
    }
    verificarTriunfo();
  }

  // Metodo para comprobar si se gana el juego
  void verificarTriunfo() {
    int cant = 0;
    for (int f = 0; f < 10; f++) {
      for (int c = 0; c < 10; c++) {
        Color col = cuadricula[f][c].getBackground();
        if (col == Color.yellow)
          cant++;
      }
    }
    if (cant == 90) {
      setTitle("Ganooooooooo");
      desactivarJuego();
    }
  }

  // Metodo recursivo que va recorriendo las filas y columnas
  void recorrer(int fil, int col) {
    if (fil >= 0 && fil < 10 && col >= 0 && col < 10) {
      if (cuadricula[fil][col].getText().equals("0")) {
        cuadricula[fil][col].setText(" ");
        cuadricula[fil][col].setBackground(Color.yellow);
        recorrer(fil, col + 1);
        recorrer(fil, col - 1);
        recorrer(fil + 1, col);
        recorrer(fil - 1, col);
        recorrer(fil - 1, col - 1);
        recorrer(fil - 1, col + 1);
        recorrer(fil + 1, col + 1);
        recorrer(fil + 1, col - 1);
      } else if (cuadricula[fil][col].getText().equals("1") ||
          cuadricula[fil][col].getText().equals("2") ||
          cuadricula[fil][col].getText().equals("3") ||
          cuadricula[fil][col].getText().equals("4") ||
          cuadricula[fil][col].getText().equals("5") ||
          cuadricula[fil][col].getText().equals("6") ||
          cuadricula[fil][col].getText().equals("7") ||
          cuadricula[fil][col].getText().equals("8")) {
        cuadricula[fil][col].setBackground(Color.yellow);
        cuadricula[fil][col].setForeground(Color.black);
      }
    }
  }

  public static void main(String[] ar) {
    Buscaminas m = new Buscaminas();
    m.setBounds(0, 0, 470, 600);
    m.setVisible(true);
  }
}