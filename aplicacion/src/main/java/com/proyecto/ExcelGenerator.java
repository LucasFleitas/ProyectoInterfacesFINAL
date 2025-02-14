package com.proyecto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {
    public void generateExcel(List<Venta> ventas) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Informe de Ventas");

            // Crear encabezados de columna
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID Venta");
            headerRow.createCell(1).setCellValue("Empleado ID");
            headerRow.createCell(2).setCellValue("Producto ID");
            headerRow.createCell(3).setCellValue("Cantidad");
            headerRow.createCell(4).setCellValue("Fecha");
            headerRow.createCell(5).setCellValue("Total Venta");

            // Llenar los datos
            int rowNum = 1;
            for (Venta venta : ventas) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(venta.getIdVenta());
                row.createCell(1).setCellValue(venta.getIdEmpleado());
                row.createCell(2).setCellValue(venta.getIdProducto());
                row.createCell(3).setCellValue(venta.getCantidad());
                row.createCell(4).setCellValue(venta.getFechaVenta().toString());
                row.createCell(5).setCellValue(venta.getTotalVenta());
            }

            // Escribir el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream("InformeVentas.xlsx")) {
                workbook.write(fileOut);
            }

            System.out.println("Informe Excel generado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

