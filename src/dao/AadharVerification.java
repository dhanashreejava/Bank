package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

import model.AadharCard;
import model.RegisterSite;

public class AadharVerification extends ConnectionDao{
	ConnectionDao connectiondao=new ConnectionDao();



	public String validatedata(RegisterSite l) {

		con=myConnection();


		
		try{
			callablestatement=(CallableStatement) con.prepareCall("{call AdharVerification(?)}");

			callablestatement.setLong(1, l.getAadharCardNumber());

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