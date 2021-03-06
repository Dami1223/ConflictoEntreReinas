package ejecucion;

import java.io.IOException;
import java.util.List;

import clases.Columna;
import clases.DiagonalPrincipal;
import clases.DiagonalSecundaria;
import clases.Fila;
import clases.Operacion;
import clases.Reina;
import clases.SinColision;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String pathEntrada = "conflictosFatiga.in";
		String pathSalida = "conflictosFatiga.out";

		List<Reina> listaDeReinas = ejecutar(pathEntrada, pathSalida);

		System.out.println(listaDeReinas);
	}

	public static List<Reina> ejecutar(String pathEntrada, String pathSalida)
			throws NumberFormatException, IOException {
		List<Reina> listaDeReinas = EntradaSalida.leer(pathEntrada);

		Operacion fila = new Fila();
		Operacion columna = new Columna();
		Operacion diagonalPrincipal = new DiagonalPrincipal();
		Operacion diagonalSecundaria = new DiagonalSecundaria();
		fila.establecerSiguiente(columna);
		columna.establecerSiguiente(diagonalPrincipal);
		diagonalPrincipal.establecerSiguiente(diagonalSecundaria);
		diagonalSecundaria.establecerSiguiente(new SinColision());

		int iteraciones = 0;

		for (int i = 0; i < listaDeReinas.size() - 1; i++) {
			for (int j = i + 1; j < listaDeReinas.size(); j++) {
				fila.comprobarColicion(listaDeReinas.get(i), listaDeReinas.get(j));
				iteraciones++;
			}
		}
		System.out.println("Iteraciones: " + iteraciones);
		System.out.println("Reinas^2: " + Math.pow(2, listaDeReinas.size()));
		EntradaSalida.escribir(pathSalida, listaDeReinas);
		return listaDeReinas;

	}

}
