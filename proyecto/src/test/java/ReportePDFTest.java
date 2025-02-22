import com.proyecto.DatabaseHelper;
import com.proyecto.Controlador.ReportePDF;
import com.proyecto.Modelo.Empleado;
import com.proyecto.Modelo.Producto;
import com.proyecto.Modelo.Venta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ReportePDFTest {

    private DatabaseHelper databaseHelperMock;

    @BeforeEach
    void setUp() {
        databaseHelperMock = mock(DatabaseHelper.class);
    }

    @Test
    void testGenerarReporte() throws IOException {
        // Datos de prueba
        List<Venta> ventas = Arrays.asList(
                new Venta(1, "Juan Perez", "Laptop", 2, "2023-10-01", 2000.0)
        );
        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "Juan Perez", "Vendedor", "2021-01-01")
        );
        List<Producto> productos = Arrays.asList(
                new Producto(1, "Laptop", "Electrónica", 1000.0, 0)
        );

        // Simular las llamadas a DatabaseHelper
        try (MockedStatic<DatabaseHelper> mockedStatic = Mockito.mockStatic(DatabaseHelper.class)) {
            mockedStatic.when(DatabaseHelper::obtenerVentas).thenReturn(ventas);
            mockedStatic.when(DatabaseHelper::obtenerEmpleados).thenReturn(empleados);
            mockedStatic.when(DatabaseHelper::obtenerProductos).thenReturn(productos);

            // Llamar al método que queremos probar
            ReportePDF.generarReporte("test_report.pdf");

            // Verificar que se llamaron los métodos de DatabaseHelper
            mockedStatic.verify(DatabaseHelper::obtenerVentas);
            mockedStatic.verify(DatabaseHelper::obtenerEmpleados);
            mockedStatic.verify(DatabaseHelper::obtenerProductos);
        }

        // Aquí podrías agregar más verificaciones, como leer el archivo PDF generado y verificar su contenido
    }
}