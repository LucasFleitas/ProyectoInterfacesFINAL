package com.proyecto.Modelo;

/**
 * Representa un producto dentro del sistema. La clase contiene información del
 * producto como su ID, nombre, categoría, precio y stock disponible.
 */
public class Producto {

    private int id_producto;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    
    /**
     * Constructor que inicializa un objeto Producto con la información proporcionada.
     * 
     * @param id_producto El ID único del producto.
     * @param nombre El nombre del producto.
     * @param categoria La categoría a la que pertenece el producto.
     * @param precio El precio del producto.
     * @param stock La cantidad de stock disponible del producto.
     */
    public Producto(int id_producto, String nombre, String categoria, double precio, int stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el ID del producto.
     * 
     * @return El ID del producto.
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * Establece el ID del producto.
     * 
     * @param id_producto El ID del producto.
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la categoría del producto.
     * 
     * @return La categoría del producto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     * 
     * @param categoria La categoría del producto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param precio El precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el stock disponible del producto.
     * 
     * @return La cantidad de stock disponible del producto.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock disponible del producto.
     * 
     * @param stock La cantidad de stock disponible del producto.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
