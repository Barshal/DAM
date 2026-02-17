package com.javafx_profesor;

import com.javafx_profesor.model.AsignaturaAlumno;
import com.javafx_profesor.model.Profesor;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;

public class ProfesorController {

    ArrayList<AsignaturaAlumno> listaAsignaturas = new ArrayList<>();
    ArrayList<AsignaturaAlumno> listaAsignaturasFiltradas = new ArrayList<>();


    AsignaturaAlumno a1 = new AsignaturaAlumno(1,"Matematicas",9.5,"Ana López");
    AsignaturaAlumno a2 = new AsignaturaAlumno(2, "Lengua", 8.7, "Carlos Ruiz");
    AsignaturaAlumno a3 = new AsignaturaAlumno(3, "Historia", 7.9, "María Sánchez");
    AsignaturaAlumno a4 = new AsignaturaAlumno(4, "Física", 6.8, "Javier Ortega");
    AsignaturaAlumno a5 = new AsignaturaAlumno(5, "Matematicas", 9.1, "Lucía Fernández");
    AsignaturaAlumno a6 = new AsignaturaAlumno(6, "Matematicas", 8.3, "Pablo García");
    AsignaturaAlumno a7 = new AsignaturaAlumno(7, "Inglés", 9.0, "Elena Torres");
    AsignaturaAlumno a8 = new AsignaturaAlumno(8, "Física", 7.5, "Raúl Martínez");
    AsignaturaAlumno a9 = new AsignaturaAlumno(9, "Física", 8.9, "Sofía Navarro");
    AsignaturaAlumno a10 = new AsignaturaAlumno(10, "Programación", 9.8, "Héctor López");

    Profesor profesor = new Profesor();

    @FXML private TextField tfNombre;
    @FXML private TextField tfApellido;
    @FXML private TextField tfCodigoUem;
    @FXML private TextField tfCurso;
    @FXML private TextField tfLocalidad;
    @FXML private TextField tfCentro;

    @FXML private TableView<AsignaturaAlumno> tablaAsignaturas;
    @FXML private TableColumn<AsignaturaAlumno, Integer> id;
    @FXML private TableColumn<AsignaturaAlumno, String> alumno;
    @FXML private TableColumn<AsignaturaAlumno, String> modulo;
    @FXML private TableColumn<AsignaturaAlumno, Double> nota;

    @FXML
    private ComboBox cbFiltro;

    @FXML
    public void initialize() {

        // Configurar columnas
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        modulo.setCellValueFactory(new PropertyValueFactory<>("modulo"));
        alumno.setCellValueFactory(new PropertyValueFactory<>("alumno"));
        nota.setCellValueFactory(new PropertyValueFactory<>("nota"));

        // Hacer la tabla editable
        tablaAsignaturas.setEditable(true);

        // Hacer la columna nota editable
        nota.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        nota.setOnEditCommit(event -> {
            AsignaturaAlumno asignatura = event.getRowValue();
            asignatura.setNota(event.getNewValue());
        });

        // Añadir asignaturas
        listaAsignaturas.add(a1);
        listaAsignaturas.add(a2);
        listaAsignaturas.add(a3);
        listaAsignaturas.add(a4);
        listaAsignaturas.add(a5);
        listaAsignaturas.add(a6);
        listaAsignaturas.add(a7);
        listaAsignaturas.add(a8);
        listaAsignaturas.add(a9);
        listaAsignaturas.add(a10);

        // Cargar datos en la tabla
        tablaAsignaturas.getItems().addAll(listaAsignaturas);

        // Rellenar datos del profesor
        tfNombre.setText(profesor.getNombre());
        tfApellido.setText(profesor.getApellidos());
        tfCodigoUem.setText(profesor.getCodigoUem());
        tfCurso.setText(profesor.getCurso());
        tfLocalidad.setText(profesor.getLocalidad());
        tfCentro.setText(profesor.getCentro());

        //Filtro con los moduloso
        cbFiltro.getItems().addAll(
                "Todos",
                "Matematicas",
                "Lengua",
                "Historia",
                "Física",
                "Inglés",
                "Programación"
        );
        cbFiltro.setOnAction(event -> {
            String filtro = cbFiltro.getValue().toString();

            if (filtro.equals("Todos")) {
                tablaAsignaturas.getItems().setAll(listaAsignaturas);
            } else {
                tablaAsignaturas.getItems().setAll(
                        listaAsignaturas.stream()
                                .filter(a -> a.getModulo().equals(filtro))
                                .toList()
                );
            }
        });

    }

}