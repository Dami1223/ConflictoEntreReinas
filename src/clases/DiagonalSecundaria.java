package clases;

public class DiagonalSecundaria implements Operacion {

	private Operacion siguiente;

	@Override
	public boolean comprobarColicion(Reina uno, Reina dos) {
		int sumaUno = uno.getColumna() + uno.getFila();
		int sumaDos = dos.getColumna() + dos.getFila();

		if (sumaUno == sumaDos) {
			if (uno.getFila() > dos.getFila()) {
				uno.getColisiones().setArribaDerecha(dos);
				dos.getColisiones().setAbajoIzquierda(uno);
			} else {
				uno.getColisiones().setAbajoIzquierda(dos);
				dos.getColisiones().setArribaDerecha(uno);
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