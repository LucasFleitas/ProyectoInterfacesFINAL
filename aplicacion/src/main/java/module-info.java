module com.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Para iText PDF
    requires kernel;
    requires layout;

    // Para Apache POI (Excel)
    requires org.apache.poi.ooxml;
    requires org.apache.poi.poi;

    opens com.proyecto to javafx.fxml;
    exports com.proyecto;
}

