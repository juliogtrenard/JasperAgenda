module es.juliogtrenard.jasperagenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens es.juliogtrenard.jasperagenda to javafx.fxml;
    exports es.juliogtrenard.jasperagenda;
    exports es.juliogtrenard.jasperagenda.controller;
    opens es.juliogtrenard.jasperagenda.controller to javafx.fxml;
    exports es.juliogtrenard.jasperagenda.model;
    opens es.juliogtrenard.jasperagenda.model to javafx.fxml;
}