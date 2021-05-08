package clases;

public class Fila implements Operacion {

	private Operacion siguiente;

	@Override
	public boolean comprobarColicion(Reina uno, Reina dos) {
		if (uno.getFila() == dos.getFila()) {
			if (uno.getColumna() < dos.getColumna()) {
				uno.getColisiones().setDerecha(dos);
				dos.getColisiones().setIzquierda(uno);
			} else {
				uno.getColisiones().setIzquierda(dos);
				dos.getColisiones().setDerecha(uno);
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
