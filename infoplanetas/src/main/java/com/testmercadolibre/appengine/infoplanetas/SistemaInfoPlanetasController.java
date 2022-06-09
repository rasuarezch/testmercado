/**
 * 
 */
package com.testmercadolibre.appengine.infoplanetas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testmercadolibre.appengine.proceso.infoplanetas.CalcularAreaTriangulo;
import com.testmercadolibre.appengine.proceso.infoplanetas.CalcularPerimetroTriagulo;
import com.testmercadolibre.appengine.proceso.infoplanetas.CalcularPosicionCartesianaBetasoide;
import com.testmercadolibre.appengine.proceso.infoplanetas.CalcularPosicionCartesianaFerengi;
import com.testmercadolibre.appengine.proceso.infoplanetas.CalcularPosicionCartesianaVulcano;
import com.testmercadolibre.appengine.proceso.infoplanetas.ICalcularPosicionCartesiana;
import com.testmercadolibre.appengine.proceso.infoplanetas.PosicionCartesiana;
import com.testmercadolibre.appengine.proceso.infoplanetas.ProcesadorPrediccionClima;
import com.testmercadolibre.appengine.proceso.infoplanetas.PuntoDentroTriangulo;
import com.testmercadolibre.appengine.proceso.infoplanetas.UbicacionTiempoPlanetas;
import com.testmercadolibre.appengine.proceso.infoplanetas.VerificarEcRectaPasoOrigen;

/**
 * @author ricardo
 *
 */
@RestController
public class SistemaInfoPlanetasController {

	@GetMapping("/sistinfoplanetas/v1/clima/{tiempo}")
	public String hello(@PathVariable("tiempo") Integer tiempo) {
		//

		List<ICalcularPosicionCartesiana> lstPlanetas = new ArrayList<>();
		lstPlanetas.add(CalcularPosicionCartesianaBetasoide::calcularPosicion);
		lstPlanetas.add(CalcularPosicionCartesianaFerengi::calcularPosicion);
		lstPlanetas.add(CalcularPosicionCartesianaVulcano::calcularPosicion);

		PosicionCartesiana posSol = new PosicionCartesiana();
		posSol.setPosX(0l);
		posSol.setPosY(0l);
		//
		UbicacionTiempoPlanetas ubicTiemPlanetas = ProcesadorPrediccionClima.obtenerDatosPlanetasXTiempo(lstPlanetas,
				CalcularAreaTriangulo::calcularArea, CalcularPerimetroTriagulo::calcularPerimetro,
				PuntoDentroTriangulo::verificarPunto, VerificarEcRectaPasoOrigen::verificarPasoOrigenRectas, posSol,
				tiempo);
		String json = "TEST";
		try {
			//

			json = new ObjectMapper().writeValueAsString(ubicTiemPlanetas);
			//
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return json;
	}

}
