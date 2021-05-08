package clases;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String pathEntrada = "conflictos.in";
		String pathSalida = "conflictos.out";

		List<Reina> listaDeReinas = EntradaSalida.leer(pathEntrada);
		Operacion fila = new Fila();
		Operacion columna = new Columna();
		Operacion diagonalPrincipal = new DiagonalPrincipal();
		Operacion diagonalSecundaria = new DiagonalSecundaria();
		fila.establecerSiguiente(columna);
		columna.establecerSiguiente(diagonalPrincipal);
		diagonalPrincipal.establecerSiguiente(diagonalSecundaria);
		diagonalSecundaria.establecerSiguiente(new SinColision());

		for (int i = 0; i < listaDeReinas.size() - 1; i++) {
			for (int j = i + 1; j < listaDeReinas.size(); j++) {
				fila.comprobarColicion(listaDeReinas.get(i), listaDeReinas.get(j));
			}
		}

		System.out.println(listaDeReinas);
		EntradaSalida.escribir(pathSalida, listaDeReinas);
	}

}
