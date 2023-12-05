package dii2dam.movieApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sentencias {

	public static void insertUser(String username, String pass) {
		
		PreparedStatement bd;
		try {

			Connection con = Conexion.conectar();
			bd = con.prepareStatement("use movieapp");

			bd.execute();
			
			String user = "INSERT INTO user (username_email, password)"+
					"VALUES (?,?)";
			
			
			bd = con.prepareStatement(user);
			bd.setString(1, username);
			bd.setString(2, pass);
			
			bd.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static ResultSet selectUserbyUsername(String comprobarUsername) {
		PreparedStatement bd;
		ResultSet a = null;
		try {

			Connection con = Conexion.conectar();
			bd = con.prepareStatement("use movieapp");

			bd.execute();
			
			String user = "SELECT username_email FROM user WHERE username_email = ?";
			
			bd = con.prepareStatement(user);
			
			bd.setString(1, comprobarUsername);
			
			a = bd.executeQuery();
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public static ResultSet selectUserbyUsernameAndPass(String comprobarUsername, String pass) {
		PreparedStatement bd;
		ResultSet a = null;
		try {

			Connection con = Conexion.conectar();
			bd = con.prepareStatement("use movieapp");

			bd.execute();
			
			String user = "SELECT username_email FROM user WHERE username_email = ? AND password = ?";
			
			bd = con.prepareStatement(user);
			
			bd.setString(1, comprobarUsername);
			bd.setString(2, pass);

			
			a = bd.executeQuery();
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	
}
