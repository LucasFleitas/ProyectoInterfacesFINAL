package com.proyecto;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.util.List;

public class PDFGenerator {
    public void generatePDF(List<Venta> ventas) {
        try {
            // Crear el escritor PDF
            PdfWriter writer = new PdfWriter("InformeVentas.pdf");

            // Crear el PdfDocument utilizando el escritor
            PdfDocument pdfDocument = new PdfDocument(writer);

            // Crear el documento de layout (contenido)
            Document document = new Document(pdfDocument);

            // Añadir título al documento
            document.add(new Paragraph("Informe de Ventas"));

            // Crear tabla con 6 columnas
            float[] columnWidths = {1, 2, 2, 2, 2, 2};  // Definir el ancho de cada columna
            Table table = new Table(columnWidths);

            // Añadir encabezados de columna
            table.addCell(new Cell().add(new Paragraph("ID Venta")));
            table.addCell(new Cell().add(new Paragraph("Empleado ID")));
            table.addCell(new Cell().add(new Paragraph("Producto ID")));
            table.addCell(new Cell().add(new Paragraph("Cantidad")));
            table.addCell(new Cell().add(new Paragraph("Fecha")));
            table.addCell(new Cell().add(new Paragraph("Total Venta")));

            // Llenar los datos de ventas en la tabla
            for (Venta venta : ventas) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getIdVenta()))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getIdEmpleado()))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getIdProducto()))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getCantidad()))));
                table.addCell(new Cell().add(new Paragraph(venta.getFechaVenta().toString())));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getTotalVenta()))));
            }

            // Añadir la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();

            System.out.println("Informe PDF generado.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
