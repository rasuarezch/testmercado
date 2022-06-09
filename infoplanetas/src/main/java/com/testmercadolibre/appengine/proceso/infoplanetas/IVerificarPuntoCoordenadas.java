/**
 * 
 */
package com.testmercadolibre.appengine.proceso.infoplanetas;

import java.util.List;

/**
 * @author ricardo
 *
 */
public interface IVerificarPuntoCoordenadas {

	boolean verificarPunto(List<PosicionCartesiana> lstCoordenadas, PosicionCartesiana puntoAVerif);

}
