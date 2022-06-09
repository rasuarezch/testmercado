/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public interface ICalcularAreaCoordenadas {

	Double calcularArea(List<PosicionCartesiana> lstCoordenadas);
}
