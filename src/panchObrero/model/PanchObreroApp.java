package panchObrero.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PanchObreroApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a PanchObrero");
        System.out.println("Seleccione sus agregados y fechas de vencimiento (separados por comas):");
        System.out.println("Ejemplo: mayonesa:2023-12-31,papas pay:2023-12-31,salsa criolla:2023-12-31");

        String[] datosAgregados = scanner.nextLine().split(",");
        Map<String, LocalDate> agregadosConFecha = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String dato : datosAgregados) {
            String[] partes = dato.split(":");
            String agregado = partes[0].trim().toLowerCase();
            LocalDate fechaVencimiento = LocalDate.parse(partes[1].trim(), formatter);

            agregadosConFecha.put(agregado, fechaVencimiento);
        }

        Pancho pancho = new Pancho(agregadosConFecha);
        PanchObrero panchObrero = new PanchObrero();

        int costoTotal = panchObrero.calcularCosto(pancho);
        System.out.println("El costo total del pancho es: $" + costoTotal);

        int poderDiarreico = panchObrero.calcularPoderDiarreico(pancho);
        System.out.println("El poder diarreico del pancho es: " + poderDiarreico + " (cantidad de agregados vencidos)");
    }
}