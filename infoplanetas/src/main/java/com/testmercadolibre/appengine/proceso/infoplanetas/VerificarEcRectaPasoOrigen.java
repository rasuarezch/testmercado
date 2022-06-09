/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public class VerificarEcRectaPasoOrigen {

	public static boolean verificarPasoOrigenRectas(List<PosicionCartesiana> lstCoordenadas,
			PosicionCartesiana posSol) {
		//
		boolean resultado = false;
		//
		PosicionCartesiana posA = lstCoordenadas.get(0);
		PosicionCartesiana posB = lstCoordenadas.get(1);
		// PosicionCartesiana posC = lstCoordenadas.get(2);
		// Ecuacion recta A-B
		// y = \cfrac{y_2 - y_1}{x_2 - x_1} \; (x - x_1) + y_1

		Long y2_y1 = posB.getPosY() - posA.getPosY();
		Long x2_x1 = posB.getPosX() - posA.getPosX();
		Long x_x1 = posSol.getPosX() - posA.getPosX();
		Long y1 = posA.getPosY();
		Long y = ((y2_y1 / x2_x1) * x_x1) + y1;
		//
		if (y <= 0) {
			// La recta pasa por el origen por consiguiente alineado al sol
			resultado = true;
		}
		//
		return resultado;
	}
}
