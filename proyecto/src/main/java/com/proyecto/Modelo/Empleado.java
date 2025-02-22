package com.proyecto.Modelo;

/**
 * Representa a un empleado dentro del sistema. La clase contiene la información del
 * empleado como su ID, nombre, cargo y fecha de contratación.
 */
public class Empleado {

    private int id_empleado;
    private String nombre;
    private String cargo;
    private String fecha_contratacion;
    
    /**
     * Constructor que inicializa un objeto Empleado con la información proporcionada.
     * 
     * @param id_empleado El ID único del empleado.
     * @param nombre El nombre del empleado.
     * @param cargo El cargo que ocupa el empleado.
     * @param fecha_contratacion La fecha en la que el empleado fue contratado.
     */
    public Empleado(int id_empleado, String nombre, String cargo, String fecha_contratacion) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fecha_contratacion = fecha_contratacion;
    }

    /**
     * Obtiene el ID del empleado.
     * 
     * @return El ID del empleado.
     */
    public int getId_empleado() {
        return id_empleado;
    }

    /**
     * Establece el ID del empleado.
     * 
     * @param id_empleado El ID del empleado.
     */
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    /**
     * Obtiene el nombre del empleado.
     * 
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * 
     * @param nombre El nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el cargo del empleado.
     * 
     * @return El cargo del empleado.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     * 
     * @param cargo El cargo del empleado.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene la fecha de contratación del empleado.
     * 
     * @return La fecha de contratación del empleado.
     */
    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    /**
     * Establece la fecha de contratación del empleado.
     * 
     * @param fecha_contratacion La fecha de contratación del empleado.
     */
    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }
}
