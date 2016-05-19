/**
 * 
 */
package icaro.aplicaciones.SIDEMA.informacion;

import java.util.ArrayList;

/**
 * @author Mike
 *
 */
public class CentroControl extends Robot {

	/**
	 * @param id
	 * @param currentPos
	 * @param energy
	 * @param leader
	 */
	private ArrayList<String> exploradores;
	private ArrayList<String> neutralizadores;
	private ArrayList<Celda> msgNeutralizador;
	private ArrayList<String> emisorNeutralizador;
	private ArrayList<Candidatos> msgExplorador;
	private ArrayList<String> emisorExplorador;
	private ArrayList<Celda> minasPendientes;
	
	public ArrayList<Celda> getMinasPendientes() {
		return minasPendientes;
	}

	public void setMinasPendientes(ArrayList<Celda> minasPendientes) {
		this.minasPendientes = minasPendientes;
	}

	public void setMapa(Mapa mapa){
		super.setMapa(mapa);
	}
	public CentroControl(String id, Celda currentPos, int energy, String leader) {
		super(id, currentPos, energy, leader);
		this.exploradores = new ArrayList<String>();
		this.neutralizadores = new ArrayList<String>();
		this.msgNeutralizador = new ArrayList<Celda>();
		this.minasPendientes = new ArrayList<Celda>();
		this.emisorNeutralizador = new ArrayList<String>();
		this.msgExplorador = new ArrayList<Candidatos>();
		this.emisorExplorador = new ArrayList<String>();
	}
	public CentroControl(String id, int i, int j, int energy, String leader) {
		super(id, i,j, energy, leader);
		this.exploradores = new ArrayList<String>();
		this.neutralizadores = new ArrayList<String>();
		this.msgNeutralizador = new ArrayList<Celda>();
		this.minasPendientes = new ArrayList<Celda>();
		this.emisorNeutralizador = new ArrayList<String>();
		this.msgExplorador = new ArrayList<Candidatos>();
		this.emisorExplorador = new ArrayList<String>();
	}
	
	public ArrayList<Celda> getMsgNeutralizador() {
		return msgNeutralizador;
	}
	
	public void actualizarMsg(Object msg, String neut){
		if(!this.emisorNeutralizador.contains(neut) && this.neutralizadores.contains(neut)){
			this.msgNeutralizador.add((Celda)msg);
			this.emisorNeutralizador.add(neut);
		}
		if(!this.emisorExplorador.contains(neut) && this.exploradores.contains(neut)){
			this.msgExplorador.add((Candidatos)msg);
			this.emisorExplorador.add(neut);
		}
	}

	public void setMsgNeutralizador(ArrayList<Celda> msgNeutralizador) {
		this.msgNeutralizador = msgNeutralizador;
	}

	public ArrayList<String> getEmisorNeutralizador() {
		return emisorNeutralizador;
	}

	public void setEmisorNeutralizador(ArrayList<String> emisorNeutralizador) {
		this.emisorNeutralizador = emisorNeutralizador;
	}

	public ArrayList<String> getExploradores() {
		return exploradores;
	}
	public void setExploradores(ArrayList<String> exploradores) {
		this.exploradores = exploradores;
	}
	public ArrayList<String> getNeutralizadores() {
		return neutralizadores;
	}
	public void setNeutralizadores(ArrayList<String> neutralizadores) {
		this.neutralizadores = neutralizadores;
	}
	
	public boolean recibidosNeutralizadores(){
		boolean e = this.getMsgNeutralizador().size() == this.getNeutralizadores().size() && this.getNeutralizadores().size() > 0;
		return e; 
	}
	public boolean recibidosExploradores(){
		boolean e = this.getMsgExplorador().size() == this.getExploradores().size() && this.getExploradores().size() > 0;
		return e; 
	}

	public ArrayList<Candidatos> getMsgExplorador() {
		return this.msgExplorador;
	}
}
