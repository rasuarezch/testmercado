/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

/**
 * * El planeta se mueve a una velocidad de 3 grado dia en sentido horario R=
 * 2000km
 * 
 * @author ricardo
 *
 */
public class CalcularPosicionCartesianaBetasoide {

	/**
	 * EL tiempo en dias
	 */
	public static PosicionCartesiana calcularPosicion(Integer tiempo) {
		// X=RCos(t)
		// Y=RSin(t)
		Integer R = 2000;
		tiempo = tiempo * 3;
		//tiempo = tiempo / 24;//horas
		double tiempoRadianes =  (tiempo * Math.PI)/180;
		double cosPos = Math.cos(tiempoRadianes);
		double sinPos = Math.sin(tiempoRadianes);
		//
		Double X = R * cosPos;
		Double Y = R * sinPos;
		// En Km
		PosicionCartesiana pc = new PosicionCartesiana();
		pc.setPosX(X.longValue());
		pc.setPosY(Y.longValue());
		//
		return pc;
	}

}
