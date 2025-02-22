Instrucciones para ejecutar la aplicación
Este proyecto está basado en Java 23 y utiliza JavaFX 23.0.2 para la interfaz gráfica. A continuación, se detallan los pasos necesarios para ejecutar la aplicación correctamente.

Requisitos
JDK 23 instalado en tu sistema.
JavaFX SDK 23.0.2 instalado y configurado en tu sistema.
Pasos para ejecutar la aplicación
Asegúrate de tener Java instalado: Para comprobar que tienes Java 23 instalado en tu máquina, abre la línea de comandos (CMD) y ejecuta:


java -version
Deberías ver algo similar a:
java version "23.0.2" 2025-01-21
Java(TM) SE Runtime Environment (build 23.0.2+11-29)
Java HotSpot(TM) 64-Bit Server VM (build 23.0.2+11-29, mixed mode)

Ubicación de tu archivo .exe: Navega a la carpeta donde se encuentra el archivo ejecutable de tu aplicación (Aplicacion.exe).

Ejecutar la aplicación desde CMD:

Abre una ventana de CMD en la misma carpeta donde se encuentra el archivo .exe.
Ejecuta el siguiente comando, sustituyendo la ruta de javafx-sdk-23.0.2\lib si es necesario:

java --module-path "C:\Program Files\Java\javafx-sdk-23.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar Aplicacion.exe
Nota: Si tu JavaFX SDK está instalado en otra ubicación, reemplaza "C:\Program Files\Java\javafx-sdk-23.0.2\lib" con la ruta correcta donde tengas los archivos de JavaFX.

Generación de informes: Al ejecutar la aplicación, verás botones que generan diferentes tipos de informes. Los informes se guardarán en la misma carpeta donde se encuentra el archivo .exe. Asegúrate de tener permisos para escribir en esa carpeta.

Problemas comunes
No se encuentra JavaFX: Si obtienes un error indicando que JavaFX no se encuentra, asegúrate de que la ruta proporcionada en el comando para --module-path sea correcta y que los archivos .jar de JavaFX estén en la carpeta especificada.

Problemas con la versión de Java: Si no estás usando la versión correcta de Java (JDK 23), descarga e instala JDK 23 desde el sitio oficial de Oracle.

Base De Datos utilizada en MySQL:
Usuario: root
Contraseña: root

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

DROP DATABASE NegocioDB;
CREATE DATABASE NegocioDB;
USE NegocioDB;

-- Crear la tabla Productos
CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

-- Crear la tabla Empleados
CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    fecha_contratacion DATE NOT NULL
);

-- Crear la tabla Ventas
CREATE TABLE Ventas (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    fecha_venta DATE NOT NULL,
    total_venta DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE
);

INSERT INTO Productos (nombre, categoria, precio, stock) VALUES 
('Laptop HP', 'Electrónica', 1200.50, 10),
('Smartphone Samsung', 'Electrónica', 850.00, 15),
('Impresora Epson', 'Oficina', 350.75, 8),
('Silla Ergonómica', 'Muebles', 250.00, 20),
('Monitor LG 24"', 'Electrónica', 300.00, 12);

INSERT INTO Empleados (nombre, cargo, fecha_contratacion) VALUES 
('Juan Pérez', 'Vendedor', '2022-05-10'),
('María Gómez', 'Gerente', '2021-03-22'),
('Carlos Rodríguez', 'Cajero', '2023-01-15'),
('Ana López', 'Vendedor', '2022-11-30'),
('David Fernández', 'Vendedor', '2023-06-18');

INSERT INTO Ventas (id_empleado, id_producto, cantidad, fecha_venta, total_venta) VALUES 
(1, 1, 2, '2024-02-10', 2401.00),  -- Juan vendió 2 laptops HP
(2, 3, 1, '2024-02-12', 350.75),   -- María vendió 1 impresora Epson
(3, 2, 3, '2024-02-14', 2550.00),  -- Carlos vendió 3 smartphones Samsung
(4, 5, 2, '2024-02-15', 600.00),   -- Ana vendió 2 monitores LG
(5, 4, 4, '2024-02-16', 1000.00);  -- David vendió 4 sillas ergonómicas

