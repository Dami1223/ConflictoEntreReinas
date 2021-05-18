package ejecucion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clases.Reina;

public class EntradaSalida {

	private static int tama�oTablero;
	
	public static void escribirEntradaFatiga(List<Reina> listaReinas, String pathEntrada) throws FileNotFoundException {
		File archivoSalida = new File(pathEntrada);
		PrintWriter pwOut = new PrintWriter(archivoSalida);
		pwOut.write(String.format("%d %d\n",(int) Math.sqrt(listaReinas.size()),listaReinas.size()));
		for (Reina reina : listaReinas) {
			pwOut.write(String.format("%d %d\n",reina.getFila(),reina.getColumna()));
		}
		pwOut.close();
	}

	public static void escribir(String pathSalida, List<Reina> reinas) throws FileNotFoundException {
		File archivoSalida = new File(pathSalida);
		PrintWriter pwOut = new PrintWriter(archivoSalida);

		for (Reina reina : reinas) {
			pwOut.write(reina.getColisiones().toString() + "\n");
		}
		pwOut.close();
	}

	public static List<Reina> leer(String path) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(new FileReader(new File(path)));
		tama�oTablero = sc.nextInt();
		int cantidadReinas = sc.nextInt();
		List<Reina> listaReinas = new ArrayList<Reina>(cantidadReinas);
		int nroReina = 1;
		while (sc.hasNextInt()) {
			int fila = sc.nextInt();
			int columna = sc.nextInt();
			listaReinas.add(new Reina(fila, columna, nroReina));
			nroReina++;
		}
		sc.close();
		return listaReinas;
		
	}

	public static int getTama�oTablero() {
		return tama�oTablero;
	}

}