package com.proyecto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataFetcher {

    public List<Producto> getProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                productos.add(producto);
            }
        }
        return productos;
    }

    public List<Empleado> getEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM Empleados";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setFechaContratacion(rs.getDate("fecha_contratacion"));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    public List<Venta> getVentas() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Ventas";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setIdEmpleado(rs.getInt("id_empleado"));
                venta.setIdProducto(rs.getInt("id_producto"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setFechaVenta(rs.getDate("fecha_venta"));
                venta.setTotalVenta(rs.getDouble("total_venta"));
                ventas.add(venta);
            }
        }
        return ventas;
    }
}
