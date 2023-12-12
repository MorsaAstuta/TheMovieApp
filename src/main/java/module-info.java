module dii2dam.movieApp {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	requires okhttp3;
	requires com.google.gson;

    opens dii2dam.movieApp to javafx.fxml;
    opens dii2dam.movieApp.controller to javafx.fxml;

    exports dii2dam.movieApp.controller;
    exports dii2dam.movieApp;
}
