package com.proyecto;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.IOException;
import java.util.List;

public class ReportePDF {
    public static void generarReporte(String destino) {
        try {
            // Obtener los datos de las ventas desde la base de datos
            List<Venta> ventas = DatabaseHelper.obtenerVentas();

            // Crear el escritor de PDF y el documento
            PdfWriter writer = new PdfWriter(destino);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Título del informe
            document.add(new Paragraph("Reporte de Ventas"));
            document.add(new Paragraph("Este es un reporte generado en PDF usando iText y datos de la base de datos"));

            // Crear una tabla para mostrar las ventas
            Table table = new Table(6);  // 6 columnas
            table.addCell(new Cell().add(new Paragraph("ID Venta")));
            table.addCell(new Cell().add(new Paragraph("Empleado")));
            table.addCell(new Cell().add(new Paragraph("Producto")));
            table.addCell(new Cell().add(new Paragraph("Cantidad")));
            table.addCell(new Cell().add(new Paragraph("Fecha Venta")));
            table.addCell(new Cell().add(new Paragraph("Total Venta")));

            // Llenar la tabla con los datos de ventas
            for (Venta venta : ventas) {
                table.addCell(new Paragraph(String.valueOf(venta.getIdVenta())));
                table.addCell(new Paragraph(venta.getEmpleado()));
                table.addCell(new Paragraph(venta.getProducto()));
                table.addCell(new Paragraph(String.valueOf(venta.getCantidad())));
                table.addCell(new Paragraph(venta.getFechaVenta()));
                table.addCell(new Paragraph(String.valueOf(venta.getTotalVenta())));
            }

            // Agregar la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();
            System.out.println("¡Reporte PDF generado con éxito!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Llamar al método para generar el reporte con los datos obtenidos de la base de datos
        generarReporte("reporte_ventas.pdf");
    }
}


