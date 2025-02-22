import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.proyecto.DatabaseHelper;
import com.proyecto.Controlador.GraficoVentas;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GraficoVentasTest {

    private ResultSet resultSetMock;

    @BeforeEach
    void setUp() throws SQLException {
        // Crear un mock de ResultSet
        resultSetMock = mock(ResultSet.class);

        // Configurar el comportamiento del ResultSet para el gráfico de productos
        when(resultSetMock.next()).thenReturn(true, true, false); // Dos filas de datos
        when(resultSetMock.getString("producto")).thenReturn("Laptop", "Smartphone");
        when(resultSetMock.getInt("total_vendida")).thenReturn(10, 5);

        // Configurar el comportamiento del ResultSet para el gráfico de empleados
        when(resultSetMock.getString("empleado")).thenReturn("Juan Perez", "Maria Lopez");
        when(resultSetMock.getDouble("total_vendido")).thenReturn(2000.0, 1500.0);
    }

    @Test
    void testGenerarGraficoProductos() throws SQLException, IOException {
        // Simular la llamada a DatabaseHelper.ejecutarConsulta
        try (MockedStatic<DatabaseHelper> mockedStatic = Mockito.mockStatic(DatabaseHelper.class)) {
            mockedStatic.when(() -> DatabaseHelper.ejecutarConsulta(anyString())).thenReturn(resultSetMock);

            // Llamar al método que queremos probar
            String destino = "test_grafico_productos.png";
            GraficoVentas.generarGraficoProductos(destino);

            // Verificar que se llamó a DatabaseHelper.ejecutarConsulta
            mockedStatic.verify(() -> DatabaseHelper.ejecutarConsulta(anyString()));

            // Verificar que el archivo se generó correctamente
            File file = new File(destino);
            assertTrue(file.exists(), "El archivo del gráfico de productos no se generó");
            file.delete(); // Eliminar el archivo después de la prueba
        }
    }

    @Test
    void testGenerarGraficoEmpleados() throws SQLException, IOException {
        // Simular la llamada a DatabaseHelper.ejecutarConsulta
        try (MockedStatic<DatabaseHelper> mockedStatic = Mockito.mockStatic(DatabaseHelper.class)) {
            mockedStatic.when(() -> DatabaseHelper.ejecutarConsulta(anyString())).thenReturn(resultSetMock);

            // Llamar al método que queremos probar
            String destino = "test_grafico_empleados.png";
            GraficoVentas.generarGraficoEmpleados(destino);

            // Verificar que se llamó a DatabaseHelper.ejecutarConsulta
            mockedStatic.verify(() -> DatabaseHelper.ejecutarConsulta(anyString()));

            // Verificar que el archivo se generó correctamente
            File file = new File(destino);
            assertTrue(file.exists(), "El archivo del gráfico de empleados no se generó");
            file.delete(); // Eliminar el archivo después de la prueba
        }
    }
}