module com.javafx_login {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.javafx_login to javafx.fxml;
    opens com.javafx_login.model to javafx.fxml;

    exports com.javafx_login;
}