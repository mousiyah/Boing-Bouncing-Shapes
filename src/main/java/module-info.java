module com.example.boing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.boing to javafx.fxml;
    exports com.example.boing;
}