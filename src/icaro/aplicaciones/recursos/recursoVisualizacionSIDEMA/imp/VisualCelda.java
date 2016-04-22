package icaro.aplicaciones.recursos.recursoVisualizacionSIDEMA.imp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.SwingConstants;

public class VisualCelda extends JButton {

	private boolean mina;
	
	public VisualCelda(boolean mina, boolean accesible) {
		this.setBorder(null);
		this.mina = mina;
		if (accesible) {
			/*if (mina) {
				ImageIcon arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/ventana/dibujos/arena_marron_mina.jpg"));
				this.setIcon(arena);
				//this.setBackground(Color.RED);
			} else {*/
				ImageIcon arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/arena_marron.jpg"));
				this.setIcon(arena);
				//this.setBackground(Color.GREEN);
			

		} else {
			ImageIcon arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/arenanegra.jpg"));
			this.setIcon(arena);
			//this.setBackground(Color.GRAY);
		}

	}
	
	public VisualCelda(){
		//ImageIcon arena = new ImageIcon("arena_marron.bmp");
		 ImageIcon arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/arena_marron.jpg"));
		this.setIcon(arena);
	    
		//this.setBackground(Color.YELLOW);
	}
	
	public void setMina(){
		ImageIcon arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/arena_marron_mina.jpg"));
		this.setIcon(arena);
	}
	
	public void minaEncontrada(){
		ImageIcon arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/explorador_mina.jpg"));
		this.setIcon(arena);
	}
	
	public void desactivarMina(){
		//CAMBIAR EL DIBUJO
		ImageIcon arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/arena_marron_mina.jpg"));
		this.setIcon(arena);
	}
	
	public synchronized void movimientoExplorador(){
		Icon arena;
		if(this.mina){
			arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/explorador_mina.jpg"));
		}else{
		 arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/explorador.jpg"));
		}this.setIcon(arena);
	}
	
	public synchronized void movimientoNeutralizador(){
		Icon arena;
		if(mina){
		arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/neutralizador-mina.jpg"));
		}else{
		arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/neutralizador.jpg"));
		}
		this.setIcon(arena);
	}
	
	public void abandonarCelda(){
		Icon arena;
		if(mina){
			arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/arena_marron_mina.jpg"));
		}else{
			arena = new ImageIcon(this.getClass().getResource("/icaro/aplicaciones/recursos/recursoVisualizacionSIDEMA/dibujos/arena_marron.jpg"));
		}
		this.setIcon(arena);
	}

}