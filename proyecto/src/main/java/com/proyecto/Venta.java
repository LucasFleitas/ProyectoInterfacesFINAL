package com.proyecto;

public class Venta {
    private int idVenta;
    private String empleado;
    private String producto;
    private int cantidad;
    private String fechaVenta;
    private double totalVenta;

    public Venta(int idVenta, String empleado, String producto, int cantidad, String fechaVenta, double totalVenta) {
        this.idVenta = idVenta;
        this.empleado = empleado;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    // Getters y setters...
    
}
