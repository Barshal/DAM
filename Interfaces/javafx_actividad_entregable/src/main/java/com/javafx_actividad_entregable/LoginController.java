package com.javafx_actividad_entregable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

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
        String tipoUsuario = cbOpciones.getValue();

        if (usuario.equals(tfUsuario.getText()) && contrasenia.equals(pfContrasenia.getText()) && tipoUsuario.equals("Profesor/a")){
            // Cambiar a pantalla profesor
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javafx_actividad_entregable/profesor.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) btnEntrar.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if ((usuario.equals(tfUsuario.getText()) && contrasenia.equals(pfContrasenia.getText()) && tipoUsuario.equals("Alumno/a"))) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javafx_actividad_entregable/alumno.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) btnEntrar.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de autenticación");
            alerta.setHeaderText("Login incorrecto");
            alerta.setContentText("El usuario, la contraseña o el tipo usuario no son válidos.");
            alerta.showAndWait();
            return;
        }
    }

}
