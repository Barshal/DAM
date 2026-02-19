module com.javafx_alumno {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires javafx.graphics;


    opens com.javafx_alumno to javafx.fxml;
    opens com.javafx_alumno.model to javafx.base;

    exports com.javafx_alumno;
}