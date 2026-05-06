package edu.udelp.sistemafiscal;

import java.util.List;

public class Rol {
    public String nombreRol;
    public List<Permiso> permisos;

    public Rol(String nombreRol, List<Permiso> permisos) {
        this.nombreRol = nombreRol;
        this.permisos = permisos;
    }
}