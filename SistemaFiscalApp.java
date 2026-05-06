package edu.udelp.sistemafiscal;

import java.util.Arrays;

public class SistemaFiscalApp {
    public static void main(String[] args) {
        Departamento deptoNorte = new Departamento("Región Norte");
        Departamento deptoSur = new Departamento("Región Sur");

        Rol analistaNorte = new Rol("Analista", Arrays.asList(
                new Permiso(TipoOperacion.CONSULTAR, TipoRecurso.DECLARACION, false)
        ));

        Rol supervisorGlobal = new Rol("Supervisor", Arrays.asList(
                new Permiso(TipoOperacion.CONSULTAR, TipoRecurso.DECLARACION, true),
                new Permiso(TipoOperacion.MODIFICAR, TipoRecurso.DECLARACION, true)
        ));

        Usuario usr1 = new Usuario("EMP-001", deptoNorte, true);
        usr1.agregarRol(analistaNorte);

        Usuario usr2 = new Usuario("SUP-999", deptoNorte, true);
        usr2.agregarRol(supervisorGlobal);

        Recurso declaracionSur = new Recurso("DEC-2023-SUR", TipoRecurso.DECLARACION, deptoSur);

        SistemaAcceso sistema = new SistemaAcceso();

        System.out.println("Simulando accesos...");
        sistema.solicitarAcceso(usr1, declaracionSur, TipoOperacion.CONSULTAR);
        sistema.solicitarAcceso(usr2, declaracionSur, TipoOperacion.CONSULTAR);

        for(int i=0; i<6; i++){
            sistema.solicitarAcceso(usr1, declaracionSur, TipoOperacion.MODIFICAR);
        }

        ProcesadorAuditoria procesador = new ProcesadorAuditoria();
        procesador.generarReportes(sistema.obtenerLogs());
    }
}
