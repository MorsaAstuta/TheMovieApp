package dii2dam.movieApp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dii2dam.movieApp.models.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Manager {
  
  // Listas y mapas para datos de los usuarios
  public static List<String> usernames = new ArrayList<>();
  public static List<String> emails = new ArrayList<>();
  public static HashMap<String, User> userByName = new HashMap<>();
  public static HashMap<String, User> userByMail = new HashMap<>();
  
  // Usuario loggeado
  public static User currentUser;
  
  /**
   * Método para cargar información desde ficheros locales.
   * @param path
   */
  public static void loadInfo(String path) {
  }
  
  /**
   * Método para almacenar información en ficheros locales.
   * @param path
   */
  public static void saveInfo(String path) {
  }
  
  /**
   * Método para registrar un usuario. Se encarga de añadir todo dato necesario a las listas y los mapas correspondientes.
   * @param user
   */
  public static void addUser(User user) {
	if (emails.contains(user.getMail())) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Correo ya registrado; el usuario no se ha podido guardar.");
      alert.showAndWait();
	} else if (usernames.contains(user.getUsername())) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Nombre de usuario ya registrado; el usuario no se ha podido guardar.");
      alert.showAndWait();
	} else {
	  usernames.add(user.getUsername());
	  emails.add(user.getMail());
	  userByName.put(user.getUsername(), user);
	  userByMail.put(user.getMail(), user);
	}
  }

  /**
   * Método para obtener los datos del usuario con el que iniciar sesión.
   * @param user
   */
  public static void logIn(User user) {
	Manager.currentUser = user;
	
	// Abrir Homepage
	
  }
}
