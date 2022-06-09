/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public class CalcularPerimetroTriagulo {

	/**
	 * Calcular perimetro de las coordenadas
	 */
	public static Double calcularPerimetro(List<PosicionCartesiana> lstCoordenadas) {
		//
		PosicionCartesiana posA = lstCoordenadas.get(0);
		PosicionCartesiana posB = lstCoordenadas.get(1);
		PosicionCartesiana posC = lstCoordenadas.get(2);
		//
		Double perimetroAB = Math
				.sqrt(Math.pow((posB.getPosX() - posA.getPosX()), 2) + Math.pow((posB.getPosY() - posA.getPosY()), 2));
		Double perimetroBC = Math
				.sqrt(Math.pow((posC.getPosX() - posB.getPosX()), 2) + Math.pow((posC.getPosY() - posB.getPosY()), 2));
		Double perimetroAC = Math
				.sqrt(Math.pow((posC.getPosX() - posA.getPosX()), 2) + Math.pow((posC.getPosY() - posA.getPosY()), 2));
		//
		Double perimetroTotal = perimetroAB + perimetroBC + perimetroAC;
		//
		return perimetroTotal;
	}

}
