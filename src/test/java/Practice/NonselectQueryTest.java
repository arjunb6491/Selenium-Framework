package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonselectQueryTest {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager .registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
		Statement state = con.createStatement();
		String query = "insert into Doctors values(4,'Cordiologist',888888,'abcd');";
		int result = state.executeUpdate(query);
		if(result>0)
		{
			System.out.println("data Updated Successfully");
		}
		else
		{
			System.out.println("data is not Updated Successfully");
			
		}

	}

}
