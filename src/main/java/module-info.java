module jonathan.lindegaard.starup.javafxwrapper {
    requires javafx.controls;
    requires javafx.fxml;

    opens jonathan.lindegaard.starup.javafxwrapper to javafx.fxml, javafx.controls;
    exports jonathan.lindegaard.starup.javafxwrapper;
}