package com.proyecto.Controlador;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import com.proyecto.DatabaseHelper;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La clase {@code GraficoVentas} es responsable de generar gráficos relacionados con las ventas en el sistema.
 * Contiene métodos para generar gráficos de ventas por producto y por empleado.
 */
public class GraficoVentas {

    /**
     * Genera un gráfico de barras que muestra las ventas totales por producto.
     * El gráfico se guarda en el archivo especificado.
     *
     * @param destino La ruta del archivo donde se guardará el gráfico generado.
     */
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

    /**
     * Genera un gráfico de barras que muestra las ventas totales por empleado.
     * El gráfico se guarda en el archivo especificado.
     *
     * @param destino La ruta del archivo donde se guardará el gráfico generado.
     */
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

    /**
     * Método principal que genera los gráficos de ventas por producto y por empleado.
     * Este método es solo para pruebas y demostración.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        generarGraficoProductos("grafico_ventas_productos.png");
        generarGraficoEmpleados("grafico_ventas_empleados.png");
    }
}
