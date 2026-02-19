package com.javafx_alumno;

import com.javafx_alumno.model.Alumno;
import com.javafx_alumno.model.AsignaturaAlumno;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AlumnoController {

    ArrayList<AsignaturaAlumno> listaAsignaturas = new ArrayList<AsignaturaAlumno>();

    AsignaturaAlumno a1 = new AsignaturaAlumno(1,"Matematicas",9.5,"Ana López");
    AsignaturaAlumno a2 = new AsignaturaAlumno(2, "Lengua", 8.7, "Carlos Ruiz");
    AsignaturaAlumno a3 = new AsignaturaAlumno(3, "Historia", 7.9, "María Sánchez");
    AsignaturaAlumno a4 = new AsignaturaAlumno(4, "Física", 6.8, "Javier Ortega");
    AsignaturaAlumno a7 = new AsignaturaAlumno(7, "Inglés", 9.0, "Elena Torres");
    AsignaturaAlumno a10 = new AsignaturaAlumno(10, "Programación", 9.8, "Héctor López");

    @FXML private Text txtTitulo;
    @FXML private TextField tfExpediente;
    @FXML private TextField tfNombre;
    @FXML private TextField tfApellido;

    @FXML private TableView<AsignaturaAlumno> tbNotas;
    @FXML private TableColumn<AsignaturaAlumno, Integer> id;
    @FXML private TableColumn<AsignaturaAlumno, String> modulo;
    @FXML private TableColumn<AsignaturaAlumno, Double> nota;

    @FXML
    private Button btnSalir;
    @FXML
    private void onSalir() {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    @FXML private Button btnAtras;


    public void initialize(){

        System.out.println("Ejecutando el Initialize");

        Alumno alumno = new Alumno();

        tfExpediente.setText(alumno.getExpediente());
        tfNombre.setText(alumno.getNombre());
        tfApellido.setText(alumno.getApellidos());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        modulo.setCellValueFactory(new PropertyValueFactory<>("modulo"));
        nota.setCellValueFactory(new PropertyValueFactory<>("nota"));

        // Añadir asignaturas
        listaAsignaturas.add(a1);
        listaAsignaturas.add(a2);
        listaAsignaturas.add(a3);
        listaAsignaturas.add(a4);
        listaAsignaturas.add(a7);
        listaAsignaturas.add(a10);

        // Cargar datos en la tabla
        tbNotas.getItems().addAll(listaAsignaturas);
    };
}
