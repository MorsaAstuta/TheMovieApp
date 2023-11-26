module dii2dam.movieApp {
    requires javafx.controls;
    requires javafx.fxml;

    opens dii2dam.movieApp to javafx.fxml;
    exports dii2dam.movieApp;
}
