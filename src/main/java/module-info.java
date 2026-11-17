module com.example.serviciosweb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens com.example.serviciosweb to javafx.fxml;
    opens com.example.serviciosweb.controller to javafx.fxml;
    opens com.example.serviciosweb.model to javafx.base;
    exports com.example.serviciosweb;
}
