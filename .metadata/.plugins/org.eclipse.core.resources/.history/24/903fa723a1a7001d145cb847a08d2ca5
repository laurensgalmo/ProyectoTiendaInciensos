package rf.ficheros.util;

/**
 * Prueba de conexión a una base de datos
 * 
 *@author laura.galvez.moya*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rf.ficheros.modelos.Country;

public class OracleJDBC {

	/**
	 * Datos de la base de datos a conectar
	 */

	public final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final static String URL = "jdbc:oracle:thin:@95.17.8.252:1521:xe";
	public final static String USUARIO = "hr";
	public final static String PASSWORD = "hr";
	private static final String DATABASE = "";

	/**
	 * QUERYs
	 * 
	 * SQL_LEER_TODOS, devuelve todos los empleados de la tabla "employees" de la
	 * base de datos hr
	 * 
	 * SQL_LEER_TODOS_COUNTRY, devuelve todos los países de la tabla "countries" de
	 * la base de datos hr
	 * 
	 */

	public final static String SQL_LEER_TODOS = "Select * from Employees";
	public final static String SQL_LEER_TODOS_COUNTRY = "Select * from Countries";

	private static Connection conn;

	public Connection abrir() throws SQLException {

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		}
		System.out.println("Oracle JDBC Driver Registered :)");

		conn = null;

		try {
			conn = DriverManager.getConnection(URL + DATABASE, USUARIO, PASSWORD);

		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return conn;

	}

	public void cerrar() throws SQLException {
		if (conn != null) {
			System.out.println("You made it, take control your database now :)");
			conn.close();
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
