/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public class CalcularAreaTriangulo {

	/**
	 * Calcular area mediante determinantes
	 * 
	 * @param lstCoordenadas
	 * @return
	 */
	public static Double calcularArea(List<PosicionCartesiana> lstCoordenadas) {
		//
		double area = 0;
		double x[][] = new double[3][3];
		//
		PosicionCartesiana posA = lstCoordenadas.get(0);
		PosicionCartesiana posB = lstCoordenadas.get(1);
		PosicionCartesiana posC = lstCoordenadas.get(2);
		//
		x[0][0] = posA.getPosX();
		x[0][1] = posA.getPosY();
		x[0][2] = 1;
		//
		x[1][0] = posB.getPosX();
		x[1][1] = posB.getPosY();
		x[1][2] = 1;
		//
		x[2][0] = posC.getPosX();
		x[2][1] = posC.getPosY();
		x[2][2] = 1;
		//
		double determinanteMatrizTresXTres = determinanteMatrizTresXTres(x);
		area = Math.abs(determinanteMatrizTresXTres);
		area = area / 2;
		double floorArea = Math.floor(area);

		return floorArea;
	}

	/**
	 * Calcular determinante 3 X 3
	 * 
	 * @param x
	 * @return
	 */
	public static double determinanteMatrizTresXTres(double x[][]) {
		double det = 0;
		det = ((x[0][0]) * (x[1][1]) * (x[2][2]) + (x[1][0]) * (x[2][1]) * (x[0][2])
				+ (x[2][0]) * (x[0][1]) * (x[1][2]))
				- ((x[2][0]) * (x[1][1]) * (x[0][2]) + (x[1][0]) * (x[0][1]) * (x[2][2])
						+ (x[0][0]) * (x[2][1]) * (x[1][2]));

		return det;
	}

}
