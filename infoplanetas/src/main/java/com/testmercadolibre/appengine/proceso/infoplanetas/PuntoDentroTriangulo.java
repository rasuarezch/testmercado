/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public class PuntoDentroTriangulo {

	public static boolean verificarPunto(List<PosicionCartesiana> lstCoordenadas, PosicionCartesiana puntoAVerif) {
		//
		boolean puntoDentroTriangulo = false;
		//
		PosicionCartesiana posA = lstCoordenadas.get(0);
		PosicionCartesiana posB = lstCoordenadas.get(1);
		PosicionCartesiana posC = lstCoordenadas.get(2);
		// Calcular D = B - A
		PosicionCartesiana posD = new PosicionCartesiana();
		posD.setPosX(posB.getPosX() - posA.getPosX());
		posD.setPosY(posB.getPosY() - posA.getPosY());
		// Calcular E = C - A
		PosicionCartesiana posE = new PosicionCartesiana();
		posE.setPosX(posC.getPosX() - posA.getPosX());
		posE.setPosY(posC.getPosY() - posA.getPosY());
		// w1 = (e.x * (a.y - p.y) + e.y * (p.x - a.x)) / (d.x * e.y - d.y * e.x);
		double w1 = (posE.getPosX() * (posA.getPosY() - puntoAVerif.getPosY())
				+ posE.getPosY() * (puntoAVerif.getPosX() - posA.getPosX()))
				/ ((posD.getPosX() * posE.getPosY()) - (posD.getPosY() * posE.getPosX()));
		// w2 = (p.y - a.y - w1 * d.y) / e.y;
		double w2 = (puntoAVerif.getPosY() - posA.getPosY() - (w1 * posD.getPosY())) / posE.getPosY();

		// El punto p se encuentra dentro del tri�ngulo
		// si se cumplen las 3 condiciones:
		if ((w1 >= 0.0) && (w2 >= 0.0) && ((w1 + w2) <= 1.0)) {
			// Punto dentro del tri�ngulo
			puntoDentroTriangulo = true;
		} else {
			// Punto fuera del tri�ngulo
			puntoDentroTriangulo = false;
		}
		//
		return puntoDentroTriangulo;
	}
}
