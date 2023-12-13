package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcselectTest {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
		Statement state = con.createStatement();
		String query = "select*from Doctors;";
		ResultSet result = state.executeQuery("query");
		if(result.next())
		{
			System.out.println(result.getString(4));
		}

	}

}
