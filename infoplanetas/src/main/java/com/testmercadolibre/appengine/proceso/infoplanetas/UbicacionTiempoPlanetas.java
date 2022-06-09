/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public class UbicacionTiempoPlanetas {

	private Long tiempo;

	private List<PosicionCartesiana> lstPosisiones;

	//
	private Long area;
	private Long perimetro;

	boolean estaSolEnCoordenadas;
	boolean estaAlineados;
	boolean estaAlineadosIncluyendoSol;

	public Long getTiempo() {
		return tiempo;
	}

	public boolean isEstaAlineadosIncluyendoSol() {
		return estaAlineadosIncluyendoSol;
	}

	public void setEstaAlineadosIncluyendoSol(boolean estaAlineadosIncluyendoSol) {
		this.estaAlineadosIncluyendoSol = estaAlineadosIncluyendoSol;
	}

	public void setTiempo(Long tiempo) {
		this.tiempo = tiempo;
	}

	public List<PosicionCartesiana> getLstPosisiones() {
		return lstPosisiones;
	}

	public void setLstPosisiones(List<PosicionCartesiana> lstPosisiones) {
		this.lstPosisiones = lstPosisiones;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public Long getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(Long perimetro) {
		this.perimetro = perimetro;
	}

	public boolean isEstaSolEnCoordenadas() {
		return estaSolEnCoordenadas;
	}

	public void setEstaSolEnCoordenadas(boolean estaSolEnCoordenadas) {
		this.estaSolEnCoordenadas = estaSolEnCoordenadas;
	}

	public boolean isEstaAlineados() {
		return estaAlineados;
	}

	public void setEstaAlineados(boolean estaAlineados) {
		this.estaAlineados = estaAlineados;
	}

}
