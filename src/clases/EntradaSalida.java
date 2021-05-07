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

	public static void main(String[] args) throws NumberFormatException, IOException {

		String pathEntrada = "conflictos.in";
		String pathSalida = "conflictos.out";

		List<Reina> listaDeReinas = leer(pathEntrada);

		listaDeReinas.get(0).getColisiones().setAbajo(new Reina(1, 1));

		System.out.println(listaDeReinas);
		escribir(pathSalida, listaDeReinas);
	}

	public static void escribir(String pathSalida, List<Reina> reinas) throws FileNotFoundException {
		File archivoSalida = new File(pathSalida);
		PrintWriter pwOut = new PrintWriter(archivoSalida);

		for (Reina reina : reinas) {
			pwOut.write(reina.getColisiones() + "");
		}
		pwOut.close();
	}

	public static List<Reina> leer(String path) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(new FileReader(new File(path)));
//		int tamañoTablero = sc.nextInt();
		int cantidadReinas = sc.nextInt();
		List<Reina> listaReinas = new ArrayList<Reina>(cantidadReinas);
		sc.useLocale(Locale.ENGLISH);

		while (sc.hasNextLine()) {
			int fila = sc.nextInt();
			int columna = sc.nextInt();
			listaReinas.add(new Reina(fila, columna));
		}
		sc.close();
		return listaReinas;
	}

}