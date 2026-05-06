package edu.udelp.sistemafiscal;

import java.time.LocalDateTime;

public class RegistroAuditoria {
    public Usuario usuario;
    public TipoOperacion operacion;
    public Recurso recurso;
    public LocalDateTime fecha;
    public boolean exitoso;
    public String mensajeError;

    public RegistroAuditoria(Usuario u, TipoOperacion o, Recurso r, boolean exitoso, String error) {
        this.usuario = u;
        this.operacion = o;
        this.recurso = r;
        this.fecha = LocalDateTime.now();
        this.exitoso = exitoso;
        this.mensajeError = error;
    }
}
