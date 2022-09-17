package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static DatabaseConnection instance;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/${nome_do_banco}";
	private String username = "${username}";
	private String passoword = "${senha}";
	
	private DatabaseConnection() throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, passoword);
		} catch (SQLException e) {
			System.out.println("Database Connection Creation Failed : " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static DatabaseConnection getInstance() throws SQLException, ClassNotFoundException {
		if(instance == null) {
			instance = new DatabaseConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	
}
