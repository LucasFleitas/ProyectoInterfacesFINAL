package com.proyecto;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataFetcher fetcher = new DataFetcher();
        try {
            List<Venta> ventas = fetcher.getVentas();
            PDFGenerator pdfGenerator = new PDFGenerator();
            pdfGenerator.generatePDF(ventas);

            ExcelGenerator excelGenerator = new ExcelGenerator();
            excelGenerator.generateExcel(ventas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

