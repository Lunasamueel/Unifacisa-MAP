package singleton;

import java.sql.SQLException;

public class DatabaseConnectionTest {

	public static void main(String[] args) {
		
		DatabaseConnection sharedConn = null;
		
		try {
			sharedConn = DatabaseConnection.getInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sharedConn.hashCode());
		
		try {
			System.out.println(sharedConn.getInstance().hashCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(sharedConn.getInstance().hashCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
