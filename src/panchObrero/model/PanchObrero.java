package panchObrero.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PanchObrero {
	 private static final int COSTO_PANCHO = 500;
	 private static final Map<String, Integer> COSTOS_AGR = new HashMap<>();

	    static {
	        COSTOS_AGR.put("mayonesa", 50);
	        COSTOS_AGR.put("mostaza", 50);
	        COSTOS_AGR.put("ketchup", 50);
	        COSTOS_AGR.put("papas pay", 80);
	        COSTOS_AGR.put("salsa criolla", 100);
	        COSTOS_AGR.put("salsa de quesos", 150);
	        COSTOS_AGR.put("salsa puta parió", 150);
	        COSTOS_AGR.put("cebolla y huevo", 180);
	        COSTOS_AGR.put("obrero desclasado", 300);
	    }
        public int calcularCosto(Pancho pancho) {
            return pancho.getAgregadosConFecha().keySet().stream()
                    .map(agregado -> COSTOS_AGR.getOrDefault(agregado.trim().toLowerCase(), 0))
                    .reduce(COSTO_PANCHO, Integer::sum);
        }

        public int calcularPoderDiarreico(Pancho pancho) {
            long vencidos = pancho.getAgregadosConFecha().entrySet().stream()
                    .filter(entry -> esAgregadoVencido(entry.getKey(), entry.getValue()))
                    .count();

            return (int) vencidos;
        }
        private boolean esAgregadoVencido(String agregado, LocalDate fechaVencimiento) {
            LocalDate fechaActual = LocalDate.now();
            return fechaActual.isAfter(fechaVencimiento);
        }
}
