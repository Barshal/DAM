module com.javafx_profesor {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.javafx_profesor to javafx.fxml;
    opens com.javafx_profesor.model to javafx.base;

    exports com.javafx_profesor;
    exports com.javafx_profesor.model;

}