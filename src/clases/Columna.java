package clases;

public class Columna implements Operacion {

	private Operacion siguiente;

	@Override
	public boolean comprobarColicion(Reina uno, Reina dos) {
		if (uno.getColumna() == dos.getColumna()) {
			if (uno.getFila() < dos.getFila()) {
				uno.getColisiones().setAbajo(dos);
				dos.getColisiones().setArriba(uno);
			} else {
				uno.getColisiones().setArriba(dos);
				dos.getColisiones().setAbajo(uno);
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