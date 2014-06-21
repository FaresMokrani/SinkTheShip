package tt.fares.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewMyTable {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection connec = DriverManager.getConnection("jdbc:mysql://localhost/Test?", "root", "Eewae5Oy6aeb");
		
		Statement stm = null;
		String query = "SELECT * FROM names;";
		
		try{
			stm = connec.createStatement();
			ResultSet rsl = stm.executeQuery(query);
			while(rsl.next()){
				int id = rsl.getInt("Id");
				String name = rsl.getString("LastName");
				System.out.println(id + "\t" + name);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			if(stm != null) {
				stm.close();
			}
		}
		
				
	}

}
