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
    public static void generarGrafico(String destino) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Consulta SQL
        String query = "SELECT p.nombre AS producto, SUM(v.cantidad) AS total_vendida " +
                       "FROM Ventas v " +
                       "JOIN Productos p ON v.id_producto = p.id_producto " +
                       "GROUP BY p.nombre";

        // Usamos el método ejecutarConsulta de DatabaseConnection
        try (ResultSet rs = DatabaseHelper.ejecutarConsulta(query)) {
            while (rs.next()) {
                String producto = rs.getString("producto");
                int totalVendida = rs.getInt("total_vendida");
                dataset.addValue(totalVendida, "Ventas", producto);
            }

            // Crear el gráfico
            JFreeChart chart = ChartFactory.createBarChart(
                    "Ventas por Producto",  // Título del gráfico
                    "Producto",             // Eje X
                    "Cantidad Vendida",     // Eje Y
                    dataset                // Datos
            );

            // Guardar el gráfico como archivo PNG
            ChartUtils.saveChartAsPNG(new File(destino), chart, 800, 600);
            System.out.println("¡Gráfico generado con éxito!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generarGrafico("grafico_ventas.png");
    }
}

