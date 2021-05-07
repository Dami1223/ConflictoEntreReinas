package clases;

public class DiagonalPrincipal implements Operacion {

	private Operacion siguiente;

	@Override
	public boolean comprobarColicion(Reina uno, Reina dos) {
		int diferenciaUno = uno.getColumna() - uno.getFila();
		int diferenciaDos = dos.getColumna() - dos.getFila();

		if (diferenciaUno == diferenciaDos) {
			if (uno.getFila() > dos.getFila()) {
				uno.getColisiones().setArribaIzquierda(dos);
				dos.getColisiones().setAbajoDerecha(uno);
			} else {
				uno.getColisiones().setAbajoDerecha(dos);
				dos.getColisiones().setArribaIzquierda(uno);
			}
			return true;
		}
		return siguiente.comprobarColicion(uno, dos);
	}

	@Override
	public void establecerSiguiente(Operacion operacion) {
		this.siguiente = operacion;

	}

}