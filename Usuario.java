package edu.udelp.sistemafiscal;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public String id;
    public List<Rol> roles;
    public Departamento departamento;
    public boolean activo;

    public Usuario(String id, Departamento departamento, boolean activo) {
        this.id = id;
        this.departamento = departamento;
        this.roles = new ArrayList<>();
        this.activo = activo;
    }

    public void agregarRol(Rol rol) {
        this.roles.add(rol);
    }
}