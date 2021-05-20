package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ejecucion.Main;

class ProfeTest {

	private final String rutaSalidaEsperada = "LoteDePrueba\\SalidaEsperada\\";
	private final String rutaSalida = "LoteDePrueba\\Salida\\";
	private final String rutaEntrada = "LoteDePrueba\\Entrada\\";

	@Test
	@DisplayName("Caso 01")
	void Caso01Test() throws NumberFormatException, IOException {
		String nombreCaso = "CasosCorreccion_Cantidades-minimas";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso 02")
	void Caso02Test() throws NumberFormatException, IOException {
		String nombreCaso = "CasosCorreccion_Conflictos-reciprocos";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso 03")
	void Caso03Test() throws NumberFormatException, IOException {
		String nombreCaso = "CasosCorreccion_Tres-en-linea";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso 04")
	void Caso04Test() throws NumberFormatException, IOException {
		String nombreCaso = "CasosCorreccion_Tablero-lleno";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso 05")
	void Caso05Test() throws NumberFormatException, IOException {
		String nombreCaso = "CasosCorreccion_CruzX";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
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

			assertEquals(lineaEsperada, lineaSalida);
		}
		assertNull(brSalida.readLine(), "La salida tiene más lineas que la esperada");
	}

}
