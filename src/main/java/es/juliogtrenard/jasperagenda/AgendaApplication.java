package es.juliogtrenard.jasperagenda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase que muestra informes de una agenda
 */
public class AgendaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AgendaApplication.class.getResource("/es/juliogtrenard/jasperagenda/fxml/agenda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("INFORMES");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * El punto de entrada de la aplicacion.
     *
     * @param args Argumentos de linea de comandos
     */
    public static void main(String[] args) {
        launch();
    }
}