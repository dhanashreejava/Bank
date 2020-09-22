package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.CallableStatement;

import model.Login;
public class LoginDao extends ConnectionDao{
	ConnectionDao cd=new ConnectionDao();
	int i=0;

	public String validatedata(Login l) {
		
		con=myConnection();



		try{
			
			callablestatement=(CallableStatement) con.prepareCall("{call login(?,?)}");
			callablestatement.setString(1,l.getUsername());
			callablestatement.setString(2,l.getPassword());
			ResultSet rs=callablestatement.executeQuery();
			if(rs.next())
			{
				return "true";
			}
			else {
				return "false";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return "false";

	}


}