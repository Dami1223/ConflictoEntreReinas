package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EntradaSalida {

	private static int tamañoTablero;

	public static void escribir(String pathSalida, List<Reina> reinas) throws FileNotFoundException {
		File archivoSalida = new File(pathSalida);
		PrintWriter pwOut = new PrintWriter(archivoSalida);

		for (Reina reina : reinas) {
			pwOut.write(reina.getColisiones().toString() + "");
		}
		pwOut.close();
	}

	public static List<Reina> leer(String path) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(new FileReader(new File(path)));
		tamañoTablero = sc.nextInt();
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

}