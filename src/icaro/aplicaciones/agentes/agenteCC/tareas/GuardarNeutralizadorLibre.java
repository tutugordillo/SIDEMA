package icaro.aplicaciones.agentes.agenteCC.tareas;

import java.util.List;

import org.jgrapht.GraphPath;

import icaro.aplicaciones.SIDEMA.informacion.Celda;
import icaro.aplicaciones.SIDEMA.informacion.CentroControl;
import icaro.aplicaciones.SIDEMA.informacion.InformarNeutralizadorLibre;
import icaro.aplicaciones.SIDEMA.informacion.Mapa;
import icaro.aplicaciones.SIDEMA.informacion.Neutralizador;
import icaro.aplicaciones.SIDEMA.informacion.OrdenDesactivar;
import icaro.aplicaciones.SIDEMA.informacion.OrdenExplorar;
import icaro.aplicaciones.SIDEMA.informacion.InformarMinaEncontrada;
import icaro.aplicaciones.SIDEMA.informacion.Robot;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class GuardarNeutralizadorLibre extends TareaSincrona {

	@Override
	public void ejecutar(Object... params) {
		try {
			CentroControl cc = (CentroControl)params[0];
			Neutralizador n = (Neutralizador)params[1];
			InformarNeutralizadorLibre o = (InformarNeutralizadorLibre)params[2];
			cc.getNeutralizadores().add(n.getId());
			this.getEnvioHechos().actualizarHechoWithoutFireRules(n);
			this.getEnvioHechos().eliminarHechoWithoutFireRules(o);
			this.getEnvioHechos().actualizarHechoWithoutFireRules(cc);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}