package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectqueryTest2 {

	public static void main(String[] args) throws SQLException  {
		int result=0;
	Connection con=null;
		try {
			
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
		Statement state = con.createStatement();
		String query = "insert into Doctors values(4,'Cordiologist',888888,'abcd');";
		 result = state.executeUpdate(query);
		}
		catch (Exception e) {
			
		}
			
		finally {
		
		if(result>0)
		{
			System.out.println("data Updated Successfully");
		}
		else {
			System.out.println("data is not Updated Successfully");
		}
		
		con.close();
		}
		
	}
}




