package panchObrero.model;

import java.time.LocalDate;
import java.util.Map;

public class Pancho {

	private Map<String, LocalDate> agregados;

	public Pancho(Map<String, LocalDate> agregados) {
		this.agregados = agregados;
	}

	public Map<String, LocalDate> getAgregadosConFecha() {
		return agregados;
	}
}