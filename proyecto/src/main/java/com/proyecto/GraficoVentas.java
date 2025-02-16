package com.proyecto;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficoVentas {
    
    public static void generarGraficoProductos(String destino) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT p.nombre AS producto, SUM(v.cantidad) AS total_vendida " +
                       "FROM Ventas v " +
                       "JOIN Productos p ON v.id_producto = p.id_producto " +
                       "GROUP BY p.nombre";

        try (ResultSet rs = DatabaseHelper.ejecutarConsulta(query)) {
            while (rs.next()) {
                String producto = rs.getString("producto");
                int totalVendida = rs.getInt("total_vendida");
                dataset.addValue(totalVendida, "Ventas", producto);
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    "Ventas por Producto", "Producto", "Cantidad Vendida", dataset);

            ChartUtils.saveChartAsPNG(new File(destino), chart, 800, 600);
            System.out.println("¡Gráfico de ventas por producto generado con éxito!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarGraficoEmpleados(String destino) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT e.nombre AS empleado, SUM(v.total_venta) AS total_vendido " +
                       "FROM Ventas v " +
                       "JOIN Empleados e ON v.id_empleado = e.id_empleado " +
                       "GROUP BY e.nombre";

        try (ResultSet rs = DatabaseHelper.ejecutarConsulta(query)) {
            while (rs.next()) {
                String empleado = rs.getString("empleado");
                double totalVendido = rs.getDouble("total_vendido");
                dataset.addValue(totalVendido, "Ventas", empleado);
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    "Ventas por Empleado", "Empleado", "Total Vendido", dataset);

            ChartUtils.saveChartAsPNG(new File(destino), chart, 800, 600);
            System.out.println("¡Gráfico de ventas por empleado generado con éxito!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generarGraficoProductos("grafico_ventas_productos.png");
        generarGraficoEmpleados("grafico_ventas_empleados.png");
    }
}


