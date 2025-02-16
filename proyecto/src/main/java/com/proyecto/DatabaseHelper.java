package com.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    // Obtener las ventas desde la base de datos
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

    public static ResultSet ejecutarConsulta(String query) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }
}
