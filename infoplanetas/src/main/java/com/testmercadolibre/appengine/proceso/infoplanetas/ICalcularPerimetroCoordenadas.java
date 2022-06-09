/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public interface ICalcularPerimetroCoordenadas {

	Double calcularPerimetro(List<PosicionCartesiana> lstCoordenadas);
}
