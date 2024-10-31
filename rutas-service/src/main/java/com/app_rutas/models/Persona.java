package com.app_rutas.models;

public class Persona {

    private Integer id;

    private String nombre;
    private String apellido;
    private String dni;
    private String fechaNacimiento;
    private String direccion;

    public Persona() {}

    public Persona(String nombre, String apellido, String dni, String fechaNacimiento, String direccion) 
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  "Nombre: " + this.nombre + "\n" +
                "Apellido: " + this.apellido + "\n" +
                "dni: " + this.dni + "\n" +
                "Fecha de nacimiento: " + this.fechaNacimiento + "\n" +
                "Direccion: " + this.direccion;
    }

}
