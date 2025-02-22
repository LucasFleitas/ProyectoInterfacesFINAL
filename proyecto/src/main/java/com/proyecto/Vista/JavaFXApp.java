package com.proyecto.Vista;

import com.proyecto.Controlador.GraficoVentas;
import com.proyecto.Controlador.ReporteExcel;
import com.proyecto.Controlador.ReportePDF;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase principal que configura la interfaz gráfica de usuario utilizando JavaFX,
 * permitiendo al usuario generar reportes en formato PDF, Excel y gráficos.
 * La interfaz contiene tres botones que activan las respectivas acciones para generar los reportes.
 */
public class JavaFXApp extends Application {

    /**
     * Inicia la interfaz gráfica de usuario, creando los botones y configurando sus acciones.
     * 
     * @param primaryStage la ventana principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        // Crear botones
        Button pdfButton = new Button("Generar PDF");
        Button excelButton = new Button("Generar Excel");
        Button chartButton = new Button("Generar Gráfico");

        // Configurar la acción para generar el reporte en PDF
        pdfButton.setOnAction(e -> ReportePDF.generarReporte("reporte_completo.pdf"));

        // Configurar la acción para generar el reporte en Excel
        excelButton.setOnAction(e -> ReporteExcel.generarReporte("reporte_completo.xlsx"));

        // Configurar la acción para generar los gráficos de ventas
        chartButton.setOnAction(e -> {
            GraficoVentas.generarGraficoProductos("grafico_ventas_productos.png");
            GraficoVentas.generarGraficoEmpleados("grafico_ventas_empleados.png");
        });

        // Crear un layout de tipo VBox para organizar los botones verticalmente
        VBox root = new VBox(10, pdfButton, excelButton, chartButton);

        // Crear la escena con el layout
        Scene scene = new Scene(root, 300, 200);

        // Configurar la ventana principal
        primaryStage.setTitle("Generador de Reportes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Método principal para lanzar la aplicación JavaFX.
     * 
     * @param args los argumentos de la línea de comandos (no se usan en este caso).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
