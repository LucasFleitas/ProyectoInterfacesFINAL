package com.proyecto.Modelo;

/**
 * Representa una venta realizada en el sistema. Contiene información sobre la venta,
 * como el ID de la venta, el empleado que la realizó, el producto vendido, la cantidad
 * vendida, la fecha de la venta y el total de la venta.
 */
public class Venta {

    private int idVenta;
    private String empleado;
    private String producto;
    private int cantidad;
    private String fechaVenta;
    private double totalVenta;

    /**
     * Constructor que inicializa un objeto Venta con la información proporcionada.
     * 
     * @param idVenta El ID único de la venta.
     * @param empleado El nombre del empleado que realizó la venta.
     * @param producto El nombre del producto vendido.
     * @param cantidad La cantidad de productos vendidos.
     * @param fechaVenta La fecha en que se realizó la venta.
     * @param totalVenta El total de la venta.
     */
    public Venta(int idVenta, String empleado, String producto, int cantidad, String fechaVenta, double totalVenta) {
        this.idVenta = idVenta;
        this.empleado = empleado;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }

    /**
     * Obtiene el ID de la venta.
     * 
     * @return El ID de la venta.
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Establece el ID de la venta.
     * 
     * @param idVenta El ID de la venta.
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Obtiene el nombre del empleado que realizó la venta.
     * 
     * @return El nombre del empleado.
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * Establece el nombre del empleado que realizó la venta.
     * 
     * @param empleado El nombre del empleado.
     */
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el nombre del producto vendido.
     * 
     * @return El nombre del producto.
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Establece el nombre del producto vendido.
     * 
     * @param producto El nombre del producto.
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la cantidad de productos vendidos.
     * 
     * @return La cantidad de productos vendidos.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos vendidos.
     * 
     * @param cantidad La cantidad de productos vendidos.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la fecha en que se realizó la venta.
     * 
     * @return La fecha de la venta.
     */
    public String getFechaVenta() {
        return fechaVenta;
    }

    /**
     * Establece la fecha en que se realizó la venta.
     * 
     * @param fechaVenta La fecha de la venta.
     */
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * Obtiene el total de la venta.
     * 
     * @return El total de la venta.
     */
    public double getTotalVenta() {
        return totalVenta;
    }

    /**
     * Establece el total de la venta.
     * 
     * @param totalVenta El total de la venta.
     */
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
}
