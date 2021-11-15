module com.gonzalo.appMusica {
    requires javafx.controls;
    requires javafx.fxml;
	requires jakarta.xml.bind;
	requires java.sql;
	requires javafx.graphics;

    opens com.gonzalo.appMusica to javafx.fxml;
    opens modelos to com.sun.xml.bind, jakarta.xml.bind;
    opens utilidades to com.sun.xml.bind, jakarta.xml.bind;
    exports com.gonzalo.appMusica;
}
