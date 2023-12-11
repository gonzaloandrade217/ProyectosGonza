package panchObrero.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import panchObrero.model.PanchObrero;
import panchObrero.model.Pancho;

public class PanchObreroTest {

    @Test
    public void test1() {
    	 PanchObrero panchObrero = new PanchObrero();

         Map<String, LocalDate> agregados = new HashMap<>();
         agregados.put("mayonesa", LocalDate.parse("2023-12-31"));
         agregados.put("papas pay", LocalDate.parse("2023-12-31"));
         agregados.put("salsa criolla", LocalDate.parse("2023-12-31"));
         Pancho panchoConAgregados = new Pancho(agregados);

         int costoPancho = panchObrero.calcularCosto(panchoConAgregados);

         assertTrue(costoPancho == 730);
    }
}