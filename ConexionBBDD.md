# CONEXION CON LA BASE DE DATOS
## CREACION DE LA CLASE
```JAVA

    // Instancia estática privada
    private static DatabaseConnection instance;

    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/NegocioDB";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    // Constructor privado para evitar instanciación externa
    private DatabaseConnection() {
        try {
            // Establecer la conexión
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método estático para obtener la instancia única
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();  // Se crea la instancia si no existe
        }
        return instance;  // Devuelve la instancia existente
    }
```

## PARA CONSULTAS
```Java
    // Métodos de la clase (ejemplo de ejecución de consultas)
    public Connection getConnection() {
        return connection;
    }

```
## CERRAR LA CONEXION
```Java
    // Cerrar la conexión
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

