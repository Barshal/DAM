module org.example.javafx_estudio {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafx_estudio to javafx.fxml;
    exports org.example.javafx_estudio;
}