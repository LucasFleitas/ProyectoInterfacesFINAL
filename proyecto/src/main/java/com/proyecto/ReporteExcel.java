package com.proyecto;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ReporteExcel {
    public static void generarReporte(String destino) {
        // Obtener las ventas desde la base de datos
        List<Venta> ventas = DatabaseHelper.obtenerVentas();

        // Crear el libro y la hoja en Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ventas");

        // Crear la fila de encabezado
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID Venta");
        header.createCell(1).setCellValue("Empleado");
        header.createCell(2).setCellValue("Producto");
        header.createCell(3).setCellValue("Cantidad");
        header.createCell(4).setCellValue("Fecha Venta");
        header.createCell(5).setCellValue("Total Venta");

        // Llenar las filas con los datos de ventas
        int rowNum = 1;
        for (Venta venta : ventas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(venta.getIdVenta());
            row.createCell(1).setCellValue(venta.getEmpleado());
            row.createCell(2).setCellValue(venta.getProducto());
            row.createCell(3).setCellValue(venta.getCantidad());
            row.createCell(4).setCellValue(venta.getFechaVenta());
            row.createCell(5).setCellValue(venta.getTotalVenta());
        }

        // Guardar el archivo Excel
        try (FileOutputStream outputStream = new FileOutputStream(destino)) {
            workbook.write(outputStream);
            workbook.close();
            System.out.println("¡Reporte Excel generado con éxito!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generarReporte("reporte_ventas.xlsx");
    }
}


