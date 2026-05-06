package edu.udelp.sistemafiscal;


public class Permiso {
    public TipoOperacion operacion;
    public TipoRecurso tipoRecurso;
    public boolean accesoGlobal;

    public Permiso(TipoOperacion operacion, TipoRecurso tipoRecurso, boolean accesoGlobal) {
        this.operacion = operacion;
        this.tipoRecurso = tipoRecurso;
        this.accesoGlobal = accesoGlobal;
    }
}