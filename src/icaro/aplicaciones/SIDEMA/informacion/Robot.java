package icaro.aplicaciones.SIDEMA.informacion;

import icaro.aplicaciones.agentes.componentesInternos.movimientoCtrl.InfoCompMovimiento;

public abstract class Robot {
	
	private String id;
	private Celda currentPos;
	private int i;
	private int j;
	private int energy;
	private InfoCompMovimiento infoCompMovt;
	private String nameCC;
	protected Mapa m;
	
	public Robot(String id, Celda currentPos, int energy, String leader) {
		this.id = id;
		this.currentPos = currentPos;
		this.energy = energy;
		this.nameCC = leader;
	}
	public Robot(String id, int i, int j, int energy, String leader) {
		this.id = id;
		this.i = i;
		this.j = j;
		this.energy = energy;
		this.nameCC = leader;
	}
	
	public Mapa getMapa(){
		return this.m;
	}
	public void setMapa(Mapa m){
		this.m = m;
		if(this.currentPos == null) this.currentPos = this.m.getCelda(i, j);
	}
	public String getCC(){
		return this.nameCC;
	}
	
	public String setCC(String cc){
		return this.nameCC = cc;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public synchronized Celda getCurrentPos() {
		return currentPos;
	}

	public synchronized void setCurrentPos(Celda currentPos) {
		this.currentPos = currentPos;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		if(energy > 0) this.energy = energy;
		else this.energy = 0;
	}

	public InfoCompMovimiento getInfoCompMovt() {
		return infoCompMovt;
	}

	public void setInfoCompMovt(InfoCompMovimiento infoCompMovt) {
		this.infoCompMovt = infoCompMovt;
	}

	@Override
	public String toString() {
		return "Robot [id=" + id + ", currentPos=" + currentPos + ", energy="
				+ energy + ", infoCompMovt=" + infoCompMovt + ", nameCC="
				+ nameCC + "]";
	}

}
