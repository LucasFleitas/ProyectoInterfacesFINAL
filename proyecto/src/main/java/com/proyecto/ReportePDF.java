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
            // Obtener los datos de las ventas, empleados y productos desde la base de datos
            List<Venta> ventas = DatabaseHelper.obtenerVentas();
            List<Empleado> empleados = DatabaseHelper.obtenerEmpleados();
            List<Producto> productos = DatabaseHelper.obtenerProductos();

            // Crear el escritor de PDF y el documento
            PdfWriter writer = new PdfWriter(destino);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // ======================== REPORTE DE VENTAS ========================
            document.add(new Paragraph("📌 Reporte de Ventas"));
            document.add(new Paragraph("Este informe muestra las ventas registradas en la base de datos.\n\n"));

            // Crear tabla de ventas
            Table tableVentas = new Table(6);  // 6 columnas
            tableVentas.addCell(new Cell().add(new Paragraph("ID Venta")));
            tableVentas.addCell(new Cell().add(new Paragraph("Empleado")));
            tableVentas.addCell(new Cell().add(new Paragraph("Producto")));
            tableVentas.addCell(new Cell().add(new Paragraph("Cantidad")));
            tableVentas.addCell(new Cell().add(new Paragraph("Fecha Venta")));
            tableVentas.addCell(new Cell().add(new Paragraph("Total Venta")));

            // Llenar la tabla con los datos de ventas
            for (Venta venta : ventas) {
                tableVentas.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getIdVenta()))));
                tableVentas.addCell(new Cell().add(new Paragraph(venta.getEmpleado())));
                tableVentas.addCell(new Cell().add(new Paragraph(venta.getProducto())));
                tableVentas.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getCantidad()))));
                tableVentas.addCell(new Cell().add(new Paragraph(venta.getFechaVenta())));
                tableVentas.addCell(new Cell().add(new Paragraph(String.valueOf(venta.getTotalVenta()))));
            }

            document.add(tableVentas);
            document.add(new Paragraph("\n\n"));

            // ======================== REPORTE DE EMPLEADOS ========================
            document.add(new Paragraph("📌 Reporte de Empleados"));
            document.add(new Paragraph("Lista de empleados registrados en el sistema.\n\n"));

            // Crear tabla de empleados
            Table tableEmpleados = new Table(4);  // 4 columnas
            tableEmpleados.addCell(new Cell().add(new Paragraph("ID Empleado")));
            tableEmpleados.addCell(new Cell().add(new Paragraph("Nombre")));
            tableEmpleados.addCell(new Cell().add(new Paragraph("Cargo")));
            tableEmpleados.addCell(new Cell().add(new Paragraph("Fecha de Contratación")));

            // Llenar la tabla con los datos de empleados
            for (Empleado empleado : empleados) {
                tableEmpleados.addCell(new Cell().add(new Paragraph(String.valueOf(empleado.getId_empleado()))));
                tableEmpleados.addCell(new Cell().add(new Paragraph(empleado.getNombre())));
                tableEmpleados.addCell(new Cell().add(new Paragraph(empleado.getCargo())));
                tableEmpleados.addCell(new Cell().add(new Paragraph(empleado.getFecha_contratacion())));
            }

            document.add(tableEmpleados);
            document.add(new Paragraph("\n\n"));

            // ======================== REPORTE DE PRODUCTOS ========================
            document.add(new Paragraph("📌 Reporte de Productos"));
            document.add(new Paragraph("Lista de productos disponibles en la base de datos.\n\n"));

            // Crear tabla de productos
            Table tableProductos = new Table(4);  // 4 columnas
            tableProductos.addCell(new Cell().add(new Paragraph("ID Producto")));
            tableProductos.addCell(new Cell().add(new Paragraph("Nombre")));
            tableProductos.addCell(new Cell().add(new Paragraph("Categoría")));
            tableProductos.addCell(new Cell().add(new Paragraph("Precio")));

            // Llenar la tabla con los datos de productos
            for (Producto producto : productos) {
                tableProductos.addCell(new Cell().add(new Paragraph(String.valueOf(producto.getId_producto()))));
                tableProductos.addCell(new Cell().add(new Paragraph(producto.getNombre())));
                tableProductos.addCell(new Cell().add(new Paragraph(producto.getCategoria())));
                tableProductos.addCell(new Cell().add(new Paragraph(String.valueOf(producto.getPrecio()))));
            }

            document.add(tableProductos);

            // ======================== CERRAR DOCUMENTO ========================
            document.close();
            System.out.println("✅ ¡Reporte PDF generado con éxito!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Llamar al método para generar el reporte con los datos obtenidos de la base de datos
        generarReporte("reporte_completo.pdf");
    }
}




