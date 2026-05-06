package edu.udelp.sistemafiscal;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcceso {
    public List<RegistroAuditoria> logs = new ArrayList<>();

    public boolean solicitarAcceso(Usuario usuario, Recurso recurso, TipoOperacion operacion) {
        if (usuario == null || !usuario.activo) {
            registrarEvento(usuario, operacion, recurso, false, "Cuenta inactiva o usuario nulo");
            return false;
        }

        boolean tienePermiso = false;
        boolean tieneAccesoGlobal = false;

        for (Rol rol : usuario.roles) {
            for (Permiso p : rol.permisos) {
                if (p.operacion == operacion && p.tipoRecurso == recurso.tipo) {
                    tienePermiso = true;
                    if (p.accesoGlobal) tieneAccesoGlobal = true;
                }
            }
        }

        if (!tienePermiso) {
            registrarEvento(usuario, operacion, recurso, false, "Rol sin autorización para este recurso");
            return false;
        }

        if (!usuario.departamento.nombre.equals(recurso.departamentoResponsable.nombre)) {
            if (!tieneAccesoGlobal) {
                registrarEvento(usuario, operacion, recurso, false, "Acceso denegado: Pertenece a otra unidad administrativa");
                return false;
            }
        }

        registrarEvento(usuario, operacion, recurso, true, "OK");
        return true;
    }

    private void registrarEvento(Usuario u, TipoOperacion o, Recurso r, boolean exitoso, String msj) {
        logs.add(new RegistroAuditoria(u, o, r, exitoso, msj));
    }

    public List<RegistroAuditoria> obtenerLogs() {
        return logs;
    }
}
