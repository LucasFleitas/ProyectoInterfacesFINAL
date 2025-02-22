package com.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase gestiona la conexión a la base de datos MySQL.
 * Proporciona métodos para obtener y cerrar la conexión de manera segura.
 * 
 * <p>La conexión se realiza utilizando los parámetros configurados en las constantes:</p>
 * <ul>
 *     <li>URL: La URL de la base de datos MySQL.</li>
 *     <li>USER: El nombre de usuario para la base de datos.</li>
 *     <li>PASSWORD: La contraseña para la base de datos.</li>
 * </ul>
 * 
 * <p>Los métodos de esta clase son estáticos y permiten obtener y cerrar la conexión a la base de datos.</p>
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class DatabaseConnection {
    
    /**
     * URL de la base de datos MySQL.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/NegocioDB";

    /**
     * Nombre de usuario de la base de datos MySQL.
     */
    private static final String USER = "root";

    /**
     * Contraseña para la base de datos MySQL.
     */
    private static final String PASSWORD = "root";

    /**
     * Instancia de conexión a la base de datos.
     */
    private static Connection connection;

    /**
     * Obtiene una conexión a la base de datos. Si no hay una conexión activa,
     * crea una nueva conexión utilizando los parámetros de configuración.
     * 
     * @return La conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar obtener la conexión.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    /**
     * Cierra la conexión a la base de datos si está abierta.
     * Si la conexión ya está cerrada, no hace nada.
     * 
     * @throws SQLException Si ocurre un error al intentar cerrar la conexión.
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
