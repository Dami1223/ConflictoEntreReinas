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
	
	private Reina referencia;

	public void setDerecha(Reina derecha) {
		this.derecha = derecha;
	}

	public void setIzquierda(Reina izquierda) {
		this.izquierda = izquierda;
	}

	public void setArriba(Reina arriba) {
		this.arriba = arriba;
	}

	public void setAbajo(Reina abajo) {
		this.abajo = abajo;
	}

	public void setArribaDerecha(Reina arribaDerecha) {
		this.arribaDerecha = arribaDerecha;
	}

	public void setArribaIzquierda(Reina arribaIzquierda) {
		this.arribaIzquierda = arribaIzquierda;
	}

	public void setAbajoDerecha(Reina abajoDerecha) {
		this.abajoDerecha = abajoDerecha;
	}

	public void setAbajoIzquierda(Reina abajoIzquierda) {
		this.abajoIzquierda = abajoIzquierda;
	}

	public void setReferencia(Reina referencia) {
		this.referencia = referencia;
	}
	
	@Override
	public String toString() {
		return "Reina= "+this.referencia;
	}
	

}
