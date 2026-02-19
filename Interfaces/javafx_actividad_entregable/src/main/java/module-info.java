module com.javafx_actividad_entregable {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires javafx.graphics;


    opens com.javafx_actividad_entregable to javafx.fxml;
    opens com.javafx_actividad_entregable.model to javafx.fxml;

    exports com.javafx_actividad_entregable;
    exports com.javafx_actividad_entregable.model;

}