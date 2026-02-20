module org.example._examendi {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens org.example._examendi.Controller to javafx.fxml;
    opens org.example._examendi to javafx.fxml;

    opens org.example._examendi.Modelo to javafx.base;

    exports org.example._examendi;
    exports org.example._examendi.Controller;
    exports org.example._examendi.Modelo;
    exports org.example._examendi.DAO;
}