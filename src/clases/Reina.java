package clases;

public class Reina {

	private int fila;
	private int columna;
	private Colision colision;

	public Reina(int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
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
		return "Reina: fila= " + this.fila + " columna= " + this.columna;
	}
}
