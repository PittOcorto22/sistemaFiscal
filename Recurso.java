package edu.udelp.sistemafiscal;

public class Recurso {
    public String id;
    public TipoRecurso tipo;
    public Departamento departamentoResponsable;

    public Recurso(String id, TipoRecurso tipo, Departamento departamentoResponsable) {
        this.id = id;
        this.tipo = tipo;
        this.departamentoResponsable = departamentoResponsable;
    }
}