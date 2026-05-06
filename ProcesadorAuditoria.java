package edu.udelp.sistemafiscal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcesadorAuditoria {

    public void generarReportes(List<RegistroAuditoria> registros) {
        System.out.println("--- INICIANDO ANÁLISIS DE AUDITORÍA ---");

        List<RegistroAuditoria> registrosValidos = new ArrayList<>();
        int registrosIncompletos = 0;

        for (RegistroAuditoria reg : registros) {
            if (reg.usuario == null || reg.recurso == null || reg.operacion == null) {
                registrosIncompletos++;
            } else {
                registrosValidos.add(reg);
            }
        }
        System.out.println("Registros omitidos por inconsistencias: " + registrosIncompletos);

        Map<TipoOperacion, Long> erroresPorOperacion = registrosValidos.stream()
                .filter(r -> !r.exitoso)
                .collect(Collectors.groupingBy(r -> r.operacion, Collectors.counting()));
        System.out.println("\nErrores por tipo de operación: " + erroresPorOperacion);

        Map<String, Long> actividadUsuarios = registrosValidos.stream()
                .collect(Collectors.groupingBy(r -> r.usuario.id, Collectors.counting()));
        System.out.println("\nUsuarios con alta actividad (>5 intentos):");
        actividadUsuarios.entrySet().stream()
                .filter(entry -> entry.getValue() > 5)
                .forEach(entry -> System.out.println("Usuario ID: " + entry.getKey() + " - Accesos: " + entry.getValue()));

        Map<String, Long> recursosSolicitados = registrosValidos.stream()
                .filter(r -> r.exitoso)
                .collect(Collectors.groupingBy(r -> r.recurso.id, Collectors.counting()));
        System.out.println("\nFrecuencia de acceso a recursos exitosos: " + recursosSolicitados);
    }
}