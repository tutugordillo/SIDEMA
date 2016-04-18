package icaro.aplicaciones.ventana;

import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfVentana extends ItfUsoRecursoSimple{

	public void mover(String IdentificadorAgente, int x, int y);
	public void minaEncontrada(int x,int y);
	public void mostrarMensaje(String msg);
	public void mostrarEntornoSimulacion();
	
	
}