package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	private final String rutaSalidaEsperada = "LoteDePrueba\\SalidaEsperada\\";
	private final String rutaSalida = "LoteDePrueba\\Salida\\";
	private final String rutaEntrada = "LoteDePrueba\\Entrada\\";
	private final int capacidadFatiga = 223;

	@Test
	@DisplayName("Caso del Enunciado")
	void EnunciadoTest() throws NumberFormatException, IOException {
		String pathSalidaEsperada = rutaSalidaEsperada + "Caso00_Enunciado.out";
		String pathEntrada = rutaEntrada + "Caso00_Enunciado.in";
		String pathSalida = rutaSalida + "Caso00_Enunciado.out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso de Fatiga")
	void fatigaTest() throws NumberFormatException, IOException {
		String nombreCaso = "CasoFatiga";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";
		EntradaSalida.escribirEntradaFatiga(generarFatiga(), pathEntrada);

		Main.ejecutar(pathEntrada, pathSalida);
		EntradaSalida.escribir(pathSalidaEsperada, generarFatigaSalidaEsperada());

		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso 01")
	void Caso01Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso01_arriba-abajo";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso 02")
	void Caso02Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso02_izq-der";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}
	
	@Test
	@DisplayName("Caso 03")
	void Caso03Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso03_diag-principal";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}
	
	@Test
	@DisplayName("Caso 04")
	void Caso04Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso04_diag-secundaria";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}

	@Test
	@DisplayName("Caso 05")
	void Caso05Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso05_arriba-abajo-repetido";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}
	
	@Test
	@DisplayName("Caso 06")
	void Caso06Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso06_izq-der-repetido";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}
	
	@Test
	@DisplayName("Caso 07")
	void Caso07Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso07_diag-principal-repetido";
		String pathSalidaEsperada = rutaSalidaEsperada + nombreCaso + ".out";
		String pathEntrada = rutaEntrada + nombreCaso + ".in";
		String pathSalida = rutaSalida + nombreCaso + ".out";

		Main.ejecutar(pathEntrada, pathSalida);
		compararArchivosSalida(pathSalidaEsperada, pathSalida);
	}
	
	@Test
	@DisplayName("Caso 08")
	void Caso08Test() throws NumberFormatException, IOException {
		String nombreCaso = "Caso08_diag-secundaria-repetido";
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

			assertEquals(lineaEsperada,lineaSalida);
		}
		assertNull(brSalida.readLine(), "La salida tiene más lineas que la esperada");
	}

	List<Reina> generarFatiga() {
		List<Reina> listaReina = new LinkedList<Reina>();
		for (int i = 1; i <= capacidadFatiga; i++)
			for (int j = 1; j <= capacidadFatiga; j++)
				listaReina.add(new Reina(i, j, 0));
		return listaReina;
	}

	List<Reina> generarFatigaSalidaEsperada() {
		List<Reina> listaReina = new LinkedList<Reina>();
		for (int i = 1; i <= capacidadFatiga; i++)
			for (int j = 1; j <= capacidadFatiga; j++) {
				Reina reina = new Reina(i, j, 0);
				Colision colision = reina.getColisiones();
				if (i + 1 <= capacidadFatiga)
					colision.setAbajo(new Reina(i + 1, j, ((i + 1 - 1) * capacidadFatiga + j)));
				if (i - 1 > 0)
					colision.setArriba(new Reina(i - 1, j, ((i - 1 - 1) * capacidadFatiga + j)));
				if (j - 1 > 0)
					colision.setIzquierda(new Reina(i, j - 1, ((i - 1) * capacidadFatiga + j - 1)));
				if (j + 1 <= capacidadFatiga)
					colision.setDerecha(new Reina(i, j + 1, ((i - 1) * capacidadFatiga + j + 1)));
				if (i - 1 > 0 && j + 1 <= capacidadFatiga)
					colision.setArribaDerecha(new Reina(i - 1, j + 1, ((i - 1 - 1) * capacidadFatiga + j + 1)));
				if (i - 1 > 0 && j - 1 > 0)
					colision.setArribaIzquierda(new Reina(i - 1, j - 1, ((i - 1 - 1) * capacidadFatiga + j - 1)));
				if (i + 1 <= capacidadFatiga && j + 1 <= capacidadFatiga)
					colision.setAbajoDerecha(new Reina(i + 1, j + 1, ((i + 1 - 1) * capacidadFatiga + j + 1)));
				if (i + 1 <= capacidadFatiga && j - 1 > 0)
					colision.setAbajoIzquierda(new Reina(i + 1, j - 1, ((i + 1 - 1) * capacidadFatiga + j - 1)));
				listaReina.add(reina);
			}
		return listaReina;
	}

}
