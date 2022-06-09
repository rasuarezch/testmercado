/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricardo
 *
 */
public class ProcesadorPrediccionClima {

//	public static List<UbicacionTiempoPlanetas> procesar(List<ICalcularPosicionCartesiana> lstPlanetasPos,
//			ICalcularAreaCoordenadas calcArea, ICalcularPerimetroCoordenadas calPerimetro,
//			IVerificarPuntoCoordenadas verifPtoCoordenadas, IVerificarPuntoCoordenadas verifRectaPasaOrigen,
//			int numPeriodos) {
//		//
//		List<UbicacionTiempoPlanetas> lstUbicTiempo = new ArrayList<>();
//		UbicacionTiempoPlanetas ubicPlaneta = null;
//		//
//		PosicionCartesiana posSol = new PosicionCartesiana();
//		posSol.setPosX(0l);
//		posSol.setPosY(0l);
//		//
//		for (int i = 1; i < numPeriodos; i++) {
//			ubicPlaneta = obtenerDatosPlanetasXTiempo(lstPlanetasPos, calcArea, calPerimetro, verifPtoCoordenadas,
//					posSol, i);
//			lstUbicTiempo.add(ubicPlaneta);
//		}
//		//
//		return lstUbicTiempo;
//
//	}

	public static UbicacionTiempoPlanetas obtenerDatosPlanetasXTiempo(List<ICalcularPosicionCartesiana> lstPlanetasPos,
			ICalcularAreaCoordenadas calcArea, ICalcularPerimetroCoordenadas calPerimetro,
			IVerificarPuntoCoordenadas verifPtoCoordenadas, IVerificarPuntoCoordenadas verifRectaPasaOrigen,
			PosicionCartesiana posSol, int tiempo) {
		//
		PosicionCartesiana posPlaneta;
		List<PosicionCartesiana> lstCoordenadas;

		Double areaTotal;
		Double perimetroTotal;
		UbicacionTiempoPlanetas ubicPlaneta = new UbicacionTiempoPlanetas();
		ubicPlaneta.setTiempo(Long.valueOf(tiempo));
		// Calcular posiciones
		lstCoordenadas = new ArrayList<>();
		for (ICalcularPosicionCartesiana iCalPos : lstPlanetasPos) {
			posPlaneta = iCalPos.calcularPosicion(tiempo);
			lstCoordenadas.add(posPlaneta);
		}
		//
		ubicPlaneta.setLstPosisiones(lstCoordenadas);
		// Verificar alineacion planetas
		areaTotal = calcArea.calcularArea(lstCoordenadas);
		ubicPlaneta.setArea(areaTotal.longValue());
		//
		perimetroTotal = calPerimetro.calcularPerimetro(lstCoordenadas);
		ubicPlaneta.setPerimetro(perimetroTotal.longValue());
		//
		if (areaTotal.intValue() <= 0) {
			// Hay alineacion entre planetas
			ubicPlaneta.setEstaAlineados(true);
			// verificar si es alineacion con el sol
			boolean pasaOrigen = verifRectaPasaOrigen.verificarPunto(lstCoordenadas, posSol);
			ubicPlaneta.setEstaAlineadosIncluyendoSol(pasaOrigen);
			// si solo no esta alineado son las condiciones optimas de temperatura y presion

		} else {
			// Calcular perimetro
			boolean solEstaEnCoordenadas = verifPtoCoordenadas.verificarPunto(lstCoordenadas, posSol);
			if (solEstaEnCoordenadas) {
				ubicPlaneta.setEstaSolEnCoordenadas(true);
			} else {
				ubicPlaneta.setEstaSolEnCoordenadas(false);
			}
		}
		//
		return ubicPlaneta;
	}
}
