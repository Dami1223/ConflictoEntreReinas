package clases;

public class SinColision implements Operacion{

	@Override
	public boolean comprobarColicion(Reina uno, Reina dos) {
		return false;
	}

	@Override
	public void establecerSiguiente(Operacion operacion) {
		throw new RuntimeException("No se puede agregar otro comportamiento");
	}

}
