package clases;

public class Reina {

	private int fila;
	private int columna;
	private Colision colision;
	private int numero;

	public Reina(int fila, int columna, int nroReina) {
		this.columna = columna;
		this.fila = fila;
		this.numero = nroReina;
		this.colision = new Colision();
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public Colision getColisiones() {
		return colision;
	}

	@Override
	public String toString() {
		return "Reina: " + this.numero + " Colisiones: " + this.colision;
	}

	public int getNumero() {
		return numero;
	}
}
