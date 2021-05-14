package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clases.Colision;
import clases.Reina;
import ejecucion.EntradaSalida;
import ejecucion.Main;

@DisplayName("Lote de Prueba")
class ReinaTest {

	@Test
	@DisplayName("Caso del Enunciado")
	void EnunciadoTest() throws NumberFormatException, IOException {
		String pathSalidaEsperada = "conflictosEsperados.out";
		String pathEntrada = "conflictos.in";
		String pathSalida = "conflictos.out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso de Fatiga")
	void fatigaTest() throws NumberFormatException, IOException {
		String pathEntrada = "conflictosFatiga.in";
		String pathSalida = "conflictosFatiga.out";
		String pathSalidaEsperada = "conflictosFatigaEsperado.out";
		EntradaSalida.escribirEntradaFatiga(generarFatiga(), pathEntrada);

		Main.ejecutar(pathEntrada, pathSalida);
		EntradaSalida.escribir(pathSalidaEsperada, generarFatigaSalidaEsperada());

		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	private void compararArchivosSalida(String pathSalidaEsperada, String pathSalida)
			throws FileNotFoundException, IOException {
		BufferedReader brSalida = new BufferedReader(new FileReader(new File(pathSalida)));
		BufferedReader brSalidaEsperda = new BufferedReader(new FileReader(new File(pathSalidaEsperada)));

		String lineaEsperada;
		while ((lineaEsperada = brSalidaEsperda.readLine()) != null) {
			String lineaSalida = brSalida.readLine();
			assertNotNull(lineaSalida, "La salida tiene más lineas que la esperada");

			assertTrue(compararLinea(new ArrayList<String>(Arrays.asList(lineaEsperada.split(" "))),
					new ArrayList<String>(Arrays.asList(lineaSalida.split(" ")))));
		}
		assertNull(brSalida.readLine(), "La salida tiene más lineas que la esperada");
	}

	boolean compararLinea(List<String> lineaEsperada, List<String> lineaSalida) {
		for (String nroReina : lineaEsperada) {
			boolean removioReina = lineaSalida.remove(nroReina);
			if (!removioReina)
				return false;
		}
		if (lineaSalida.size() > 0)
			return false;
		return true;
	}

	List<Reina> generarFatiga() {
		List<Reina> listaReina = new LinkedList<Reina>();
		int tamaño = 223;
		for (int i = 1; i <= tamaño; i++)
			for (int j = 1; j <= tamaño; j++)
				listaReina.add(new Reina(i, j, 0));
		return listaReina;
	}

	List<Reina> generarFatigaSalidaEsperada() {
		List<Reina> listaReina = new LinkedList<Reina>();
		int tamaño = 223;
		for (int i = 1; i <= tamaño; i++)
			for (int j = 1; j <= tamaño; j++) {
				Reina reina = new Reina(i, j, 0);
				Colision colision = reina.getColisiones();
				if (i + 1 <= tamaño)
					colision.setAbajo(new Reina(i + 1, j, ((i + 1 - 1) * tamaño + j)));
				if (i - 1 > 0)
					colision.setArriba(new Reina(i - 1, j, ((i - 1 - 1) * tamaño + j)));
				if (j - 1 > 0)
					colision.setIzquierda(new Reina(i, j - 1, ((i - 1) * tamaño + j - 1)));
				if (j + 1 <= tamaño)
					colision.setDerecha(new Reina(i, j + 1, ((i - 1) * tamaño + j + 1)));
				if (i - 1 > 0 && j + 1 <= tamaño)
					colision.setArribaDerecha(new Reina(i - 1, j + 1, ((i - 1 - 1) * tamaño + j + 1)));
				if (i - 1 > 0 && j - 1 > 0)
					colision.setArribaIzquierda(new Reina(i - 1, j - 1, ((i - 1 - 1) * tamaño + j - 1)));
				if (i + 1 <= tamaño && j + 1 <= tamaño)
					colision.setAbajoDerecha(new Reina(i + 1, j + 1, ((i + 1 - 1) * tamaño + j + 1)));
				if (i + 1 <= tamaño && j - 1 > 0)
					colision.setAbajoIzquierda(new Reina(i + 1, j - 1, ((i + 1 - 1) * tamaño + j - 1)));
				listaReina.add(reina);
			}
		return listaReina;
	}

}
