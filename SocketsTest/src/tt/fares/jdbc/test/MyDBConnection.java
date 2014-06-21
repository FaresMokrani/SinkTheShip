package tt.fares.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {

	private static String dbName = "jdbc:mysql://localhost/Test?";
	private static String user = "root";
	private static String password = "Eewae5Oy6aeb";
	private static Connection connection = null;

	public static Connection connectToDB() {
		if (connection == null) {
			try {
				connection = DriverManager
						.getConnection(dbName, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
}
