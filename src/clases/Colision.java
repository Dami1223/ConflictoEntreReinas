package clases;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Colision {

	private Reina derecha;
	private Reina izquierda;
	private Reina arriba;
	private Reina abajo;
	private Reina arribaDerecha;
	private Reina arribaIzquierda;
	private Reina abajoDerecha;
	private Reina abajoIzquierda;
	private int cantidadColisiones;

	public void setDerecha(Reina reina) {
		if (this.derecha == null) {
			this.derecha = reina;
			cantidadColisiones++;
		} else if (this.derecha.getColumna() > reina.getColumna())
			this.derecha = reina;
	}

	public void setIzquierda(Reina reina) {
		if (this.izquierda == null) {
			this.izquierda = reina;
			cantidadColisiones++;
		} else if (this.izquierda.getColumna() < reina.getColumna())
			this.izquierda = reina;
	}

	public void setArriba(Reina reina) {
		if (this.arriba == null) {
			this.arriba = reina;
			cantidadColisiones++;
		} else if (this.arriba.getFila() < reina.getFila())
			this.arriba = reina;
	}

	public void setAbajo(Reina reina) {
		if (this.abajo == null) {
			this.abajo = reina;
			cantidadColisiones++;
		} else if (this.abajo.getFila() > reina.getFila())
			this.abajo = reina;
	}

	public void setArribaDerecha(Reina reina) {
		if (this.arribaDerecha == null) {
			this.arribaDerecha = reina;
			cantidadColisiones++;
		} else if (this.arribaDerecha.getFila() < reina.getFila())
			this.arribaDerecha = reina;
	}

	public void setArribaIzquierda(Reina reina) {
		if (this.arribaIzquierda == null) {
			this.arribaIzquierda = reina;
			cantidadColisiones++;
		} else if (this.arribaIzquierda.getColumna() < reina.getColumna())
			this.arribaIzquierda = reina;
	}

	public void setAbajoDerecha(Reina reina) {
		if (this.abajoDerecha == null) {
			this.abajoDerecha = reina;
			cantidadColisiones++;
		} else if (this.abajoDerecha.getColumna() > reina.getColumna())
			this.abajoDerecha = reina;
	}

	public void setAbajoIzquierda(Reina reina) {
		if (this.abajoIzquierda == null) {
			this.abajoIzquierda = reina;
			cantidadColisiones++;
		} else if (this.abajoIzquierda.getColumna() < reina.getColumna())
			this.abajoIzquierda = reina;
	}

	@Override
	public String toString() {
		List<Integer> listaReinas = new LinkedList<Integer>();

		String resultado = "" + cantidadColisiones;
		if (derecha != null)
			listaReinas.add(derecha.getNumero());
		if (izquierda != null)
			listaReinas.add(izquierda.getNumero());
		if (abajo != null)
			listaReinas.add(abajo.getNumero());
		if (arriba != null)
			listaReinas.add(arriba.getNumero());
		if (arribaIzquierda != null)
			listaReinas.add(arribaIzquierda.getNumero());
		if (arribaDerecha != null)
			listaReinas.add(arribaDerecha.getNumero());
		if (abajoDerecha != null)
			listaReinas.add(abajoDerecha.getNumero());
		if (abajoIzquierda != null)
			listaReinas.add(abajoIzquierda.getNumero());

		listaReinas.sort(null);
		for (Integer nroReina : listaReinas) {
			resultado += " " + nroReina;
		}

		return resultado;
	}

}
