package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MySqlManager {

	private static String url = "jdbc:mysql://localhost:3306";
	private static String database = "SMA";
	private static String login = "root";
	private static String password = "";
	private static String driver = "com.mysql.jdbc.Driver";

	private static Connection cnx;

	private MySqlManager() {
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (cnx == null) {

			Class.forName(driver);
			try {
				cnx = DriverManager.getConnection(url + "/" + database, login, password);
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}

		}
		return cnx;
	}
}
