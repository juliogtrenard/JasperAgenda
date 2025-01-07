package es.juliogtrenard.jasperagenda.controller;

import es.juliogtrenard.jasperagenda.AgendaApplication;
import es.juliogtrenard.jasperagenda.dao.DaoPersona;
import es.juliogtrenard.jasperagenda.dao.DaoEmail;
import es.juliogtrenard.jasperagenda.dao.DaoTelefono;
import es.juliogtrenard.jasperagenda.db.DBConnect;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Controla los eventos de la ventana principal
 */
public class AgendaController {
    @FXML
    private RadioButton rbInforme1;

    @FXML
    private RadioButton rbInforme2;

    @FXML
    private RadioButton rbInforme3;

    @FXML
    private ToggleGroup tgInforme;

    /**
     * Abre el informe seleccionado
     *
     * @param event evento del usuario
     */
    @FXML
    void aceptar(ActionEvent event) {
        if (rbInforme1.isSelected()) {
            lanzarInformePersonas("InformePersonas");
        } else if (rbInforme2.isSelected()) {
            lanzarInformePersonas("InformePersonas2");
        } else {
            lanzarSubinforme();
        }
    }

    /**
     * Cierra la aplicación
     *
     * @param event evento del usuario
     */
    @FXML
    void cancelar(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Carga y lanza el informe de JasperReport
     *
     * @param informe nombre del archivo del informe a lanzar
     */
    public void lanzarInformePersonas(String informe) {
        DBConnect connection;
        try {
            connection = new DBConnect();

            // Carga los datos
            HashMap<String, Object> parameters = DaoPersona.findAll();

            // Busca el informe
            JasperReport report = (JasperReport) JRLoader.loadObject(AgendaApplication.class.getResource("reports/" + informe + ".jasper"));

            // Carga el informe
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, connection.getConnection());

            // Instancia el informe
            JasperViewer viewer = new JasperViewer(jprint, false);

            // Muestra el informe
            viewer.setVisible(true);
        } catch (JRException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Error al cargar el informe");
            Platform.exit();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Error en la base de datos");
            Platform.exit();
        }
    }

    /**
     * Función que carga y lanza el informe de JasperReport
     */
    public void lanzarSubinforme() {
        DBConnect connection;
        try {
            connection = new DBConnect();

            // Carga los datos
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("PERSONS", DaoPersona.todasPersonas());
            parameters.put("EMAILS", DaoEmail.todosEmails());
            parameters.put("TELEFONOS", DaoTelefono.todosTelefonos());

            // Obtiene el informe
            JasperReport report = (JasperReport) JRLoader.loadObject(AgendaApplication.class.getResource("reports/InformePersonas3.jasper"));

            // Carga el informe
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, connection.getConnection());

            // Instancia el informe
            JasperViewer viewer = new JasperViewer(jprint, false);

            // Muestra el informe
            viewer.setVisible(true);
        } catch (JRException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Error al cargar el informe");
            Platform.exit();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Error en la base de datos");
            Platform.exit();
        }
    }

    /**
     * Muestra un mensaje de alerta al usuario
     *
     * @param mensaje de error a mostrar
     */
    public void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}