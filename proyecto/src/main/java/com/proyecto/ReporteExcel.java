package com.proyecto;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ReporteExcel {
    public static void generarReporte(String destino) {
        // Obtener los datos desde la base de datos
        List<Venta> ventas = DatabaseHelper.obtenerVentas();
        List<Producto> productos = DatabaseHelper.obtenerProductos();
        List<Empleado> empleados = DatabaseHelper.obtenerEmpleados();

        // Crear el libro de Excel
        Workbook workbook = new XSSFWorkbook();

        // ---- HOJA 1: VENTAS ----
        Sheet sheetVentas = workbook.createSheet("Ventas");

        // Encabezado de ventas
        Row headerVentas = sheetVentas.createRow(0);
        headerVentas.createCell(0).setCellValue("ID Venta");
        headerVentas.createCell(1).setCellValue("Empleado");
        headerVentas.createCell(2).setCellValue("Producto");
        headerVentas.createCell(3).setCellValue("Cantidad");
        headerVentas.createCell(4).setCellValue("Fecha Venta");
        headerVentas.createCell(5).setCellValue("Total Venta");

        // Llenar los datos de ventas
        int rowNumVentas = 1;
        for (Venta venta : ventas) {
            Row row = sheetVentas.createRow(rowNumVentas++);
            row.createCell(0).setCellValue(venta.getIdVenta());
            row.createCell(1).setCellValue(venta.getEmpleado());
            row.createCell(2).setCellValue(venta.getProducto());
            row.createCell(3).setCellValue(venta.getCantidad());
            row.createCell(4).setCellValue(venta.getFechaVenta());
            row.createCell(5).setCellValue(venta.getTotalVenta());
        }

        // ---- HOJA 2: PRODUCTOS ----
        Sheet sheetProductos = workbook.createSheet("Productos");

        // Encabezado de productos
        Row headerProductos = sheetProductos.createRow(0);
        headerProductos.createCell(0).setCellValue("ID Producto");
        headerProductos.createCell(1).setCellValue("Nombre");
        headerProductos.createCell(2).setCellValue("Categoría");
        headerProductos.createCell(3).setCellValue("Precio");
        headerProductos.createCell(4).setCellValue("Stock");

        // Llenar los datos de productos
        int rowNumProductos = 1;
        for (Producto producto : productos) {
            Row row = sheetProductos.createRow(rowNumProductos++);
            row.createCell(0).setCellValue(producto.getId_producto());
            row.createCell(1).setCellValue(producto.getNombre());
            row.createCell(2).setCellValue(producto.getCategoria());
            row.createCell(3).setCellValue(producto.getPrecio());
            row.createCell(4).setCellValue(producto.getStock());
        }

        // ---- HOJA 3: EMPLEADOS ----
        Sheet sheetEmpleados = workbook.createSheet("Empleados");

        // Encabezado de empleados
        Row headerEmpleados = sheetEmpleados.createRow(0);
        headerEmpleados.createCell(0).setCellValue("ID Empleado");
        headerEmpleados.createCell(1).setCellValue("Nombre");
        headerEmpleados.createCell(2).setCellValue("Cargo");
        headerEmpleados.createCell(3).setCellValue("Fecha de Contratación");

        // Llenar los datos de empleados
        int rowNumEmpleados = 1;
        for (Empleado empleado : empleados) {
            Row row = sheetEmpleados.createRow(rowNumEmpleados++);
            row.createCell(0).setCellValue(empleado.getId_empleado());
            row.createCell(1).setCellValue(empleado.getNombre());
            row.createCell(2).setCellValue(empleado.getCargo());
            row.createCell(3).setCellValue(empleado.getFecha_contratacion());
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
        generarReporte("reporte_completo.xlsx");
    }
}



