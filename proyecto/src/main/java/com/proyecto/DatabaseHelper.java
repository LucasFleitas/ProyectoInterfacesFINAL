package com.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.Modelo.Empleado;
import com.proyecto.Modelo.Producto;
import com.proyecto.Modelo.Venta;

/**
 * Clase que proporciona métodos estáticos para interactuar con la base de datos
 * y recuperar información sobre ventas, empleados y productos.
 */
public class DatabaseHelper {

    /**
     * Obtiene una lista de ventas desde la base de datos.
     * 
     * @return una lista de objetos {@link Venta} con los datos de las ventas.
     */
    public static List<Venta> obtenerVentas() {
        List<Venta> ventas = new ArrayList<>();
        String query = "SELECT v.id_venta, e.nombre AS empleado, p.nombre AS producto, v.cantidad, v.fecha_venta, v.total_venta " +
                       "FROM Ventas v " +
                       "JOIN Empleados e ON v.id_empleado = e.id_empleado " +
                       "JOIN Productos p ON v.id_producto = p.id_producto";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venta venta = new Venta(
                        rs.getInt("id_venta"),
                        rs.getString("empleado"),
                        rs.getString("producto"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha_venta"),
                        rs.getDouble("total_venta")
                );
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    /**
     * Ejecuta una consulta SQL personalizada y devuelve el {@link ResultSet} correspondiente.
     * 
     * @param query la consulta SQL que se ejecutará.
     * @return el {@link ResultSet} obtenido de la consulta.
     */
    public static ResultSet ejecutarConsulta(String query) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    /**
     * Obtiene una lista de empleados desde la base de datos.
     * 
     * @return una lista de objetos {@link Empleado} con los datos de los empleados.
     */
    public static List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT id_empleado, nombre, cargo, fecha_contratacion FROM Empleados";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("cargo"),
                        rs.getString("fecha_contratacion")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    /**
     * Obtiene una lista de productos desde la base de datos.
     * 
     * @return una lista de objetos {@link Producto} con los datos de los productos.
     */
    public static List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT id_producto, nombre, categoria, precio, stock FROM Productos";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}