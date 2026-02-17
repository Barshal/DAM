package com.javafx_login;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Text txtUsuario;
    @FXML
    private Text txtContrasenia;
    @FXML
    private Text txtTipoUsuario;

    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField pfContrasenia;


    @FXML
    private ComboBox<String> cbOpciones;

    @FXML
    public void initialize() {
        cbOpciones.getItems().addAll(
                "Alumno/a",
                "Profesor/a"
        );
    }


    @FXML
    private ImageView ivLogo;

    @FXML
    private Button btnLimpiar;
    @FXML
    private void onLimpiar() {
        tfUsuario.setText("");
        pfContrasenia.setText("");
    }

    @FXML
    private Button btnSalir;
    @FXML
    private void onSalir() {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btnEntrar;
    @FXML
    private void onEntrar() {
        String usuario = "Hector";
        String contrasenia = "uem";

        if (usuario.equals(tfUsuario.getText()) && contrasenia.equals(pfContrasenia.getText())){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Autentificación correcta");
            alerta.setHeaderText("Login correcto");
            alerta.setContentText("Login realizado correctamente.");
            alerta.showAndWait();
            return;
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de autenticación");
            alerta.setHeaderText("Login incorrecto");
            alerta.setContentText("El usuario o la contraseña no son válidos.");
            alerta.showAndWait();
            return;

        }
    }

}
