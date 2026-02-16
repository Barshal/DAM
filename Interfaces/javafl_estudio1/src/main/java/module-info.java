module com.javafl_estudio1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafl_estudio1 to javafx.fxml;
    exports com.javafl_estudio1;
}