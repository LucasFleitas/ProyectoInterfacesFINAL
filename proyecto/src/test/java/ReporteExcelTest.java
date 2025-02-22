import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.proyecto.DatabaseHelper;
import com.proyecto.Controlador.ReporteExcel;
import com.proyecto.Modelo.Empleado;
import com.proyecto.Modelo.Producto;
import com.proyecto.Modelo.Venta;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReporteExcelTest {

    private List<Venta> ventas;
    private List<Producto> productos;
    private List<Empleado> empleados;

    @BeforeEach
    void setUp() {
        // Datos de prueba
        ventas = Arrays.asList(
                new Venta(1, "Juan Perez", "Laptop", 2, "2023-10-01", 2000.0)
        );
        productos = Arrays.asList(
                new Producto(1, "Laptop", "Electrónica", 1000.0, 10)
        );
        empleados = Arrays.asList(
                new Empleado(1, "Juan Perez", "Vendedor", "2021-01-01")
        );
    }

    @Test
    void testGenerarReporte() throws IOException {
        // Simular las llamadas a DatabaseHelper
        try (MockedStatic<DatabaseHelper> mockedStatic = Mockito.mockStatic(DatabaseHelper.class)) {
            mockedStatic.when(DatabaseHelper::obtenerVentas).thenReturn(ventas);
            mockedStatic.when(DatabaseHelper::obtenerProductos).thenReturn(productos);
            mockedStatic.when(DatabaseHelper::obtenerEmpleados).thenReturn(empleados);

            // Llamar al método que queremos probar
            String destino = "test_report.xlsx";
            ReporteExcel.generarReporte(destino);

            // Verificar que se llamaron los métodos de DatabaseHelper
            mockedStatic.verify(DatabaseHelper::obtenerVentas);
            mockedStatic.verify(DatabaseHelper::obtenerProductos);
            mockedStatic.verify(DatabaseHelper::obtenerEmpleados);

            // Verificar que el archivo Excel se generó correctamente
            try (FileInputStream file = new FileInputStream(destino);
                 Workbook workbook = new XSSFWorkbook(file)) {

                // Verificar la hoja de Ventas
                Sheet sheetVentas = workbook.getSheet("Ventas");
                assertNotNull(sheetVentas, "La hoja de Ventas no existe");
                assertEquals(2, sheetVentas.getPhysicalNumberOfRows(), "Número incorrecto de filas en Ventas");

                // Verificar la hoja de Productos
                Sheet sheetProductos = workbook.getSheet("Productos");
                assertNotNull(sheetProductos, "La hoja de Productos no existe");
                assertEquals(2, sheetProductos.getPhysicalNumberOfRows(), "Número incorrecto de filas en Productos");

                // Verificar la hoja de Empleados
                Sheet sheetEmpleados = workbook.getSheet("Empleados");
                assertNotNull(sheetEmpleados, "La hoja de Empleados no existe");
                assertEquals(2, sheetEmpleados.getPhysicalNumberOfRows(), "Número incorrecto de filas en Empleados");
            }
        }
    }
}