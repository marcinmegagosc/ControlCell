module org.example.controlcell {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.controlcell to javafx.fxml;
    exports org.example.controlcell;
}