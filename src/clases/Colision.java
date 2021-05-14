package clases;

public class Colision {

	private Reina derecha;
	private Reina izquierda;
	private Reina arriba;
	private Reina abajo;
	private Reina arribaDerecha;
	private Reina arribaIzquierda;
	private Reina abajoDerecha;
	private Reina abajoIzquierda;
	private int colisiones;

	public void setDerecha(Reina reina) {
		if (this.derecha == null) {
			this.derecha = reina;
			colisiones++;
		} else if (this.derecha.getColumna() > reina.getColumna())
			this.derecha = reina;
	}

	public void setIzquierda(Reina reina) {
		if (this.izquierda == null) {
			this.izquierda = reina;
			colisiones++;
		} else if (this.izquierda.getColumna() < reina.getColumna())
			this.izquierda = reina;
	}

	public void setArriba(Reina reina) {
		if (this.arriba == null) {
			this.arriba = reina;
			colisiones++;
		} else if (this.arriba.getFila() < reina.getFila())
			this.arriba = reina;
	}

	public void setAbajo(Reina reina) {
		if (this.abajo == null) {
			this.abajo = reina;
			colisiones++;
		} else if (this.abajo.getFila() > reina.getFila())
			this.abajo = reina;
	}

	public void setArribaDerecha(Reina reina) {
		if (this.arribaDerecha == null) {
			this.arribaDerecha = reina;
			colisiones++;
		} else if (this.arribaDerecha.getFila() < reina.getFila())
			this.arribaDerecha = reina;
	}

	public void setArribaIzquierda(Reina reina) {
		if (this.arribaIzquierda == null) {
			this.arribaIzquierda = reina;
			colisiones++;
		} else if (this.arribaIzquierda.getColumna() < reina.getColumna())
			this.arribaIzquierda = reina;
	}

	public void setAbajoDerecha(Reina reina) {
		if (this.abajoDerecha == null) {
			this.abajoDerecha = reina;
			colisiones++;
		} else if (this.abajoDerecha.getColumna() > reina.getColumna())
			this.abajoDerecha = reina;
	}

	public void setAbajoIzquierda(Reina reina) {
		if (this.abajoIzquierda == null) {
			this.abajoIzquierda = reina;
			colisiones++;
		} else if (this.abajoIzquierda.getColumna() < reina.getColumna())
			this.abajoIzquierda = reina;
	}

	@Override
	public String toString() {

		String resultado = "" + colisiones + " ";
		resultado += (derecha == null ? "" : derecha.getNumero()) + " ";
		resultado += (izquierda == null ? "" : izquierda.getNumero()) + " ";
		resultado += (arriba == null ? "" : arriba.getNumero() + " ") + " ";
		resultado += (abajo == null ? "" : abajo.getNumero()) + " ";
		resultado += (arribaDerecha == null ? "" : arribaDerecha.getNumero()) + " ";
		resultado += (arribaIzquierda == null ? "" : arribaIzquierda.getNumero()) + " ";
		resultado += (abajoDerecha == null ? "" : abajoDerecha.getNumero()) + " ";
		resultado += (abajoIzquierda == null ? "" : abajoIzquierda.getNumero());
		return resultado.trim().replaceAll("\\s+", " ") + "\n";
	}

}
