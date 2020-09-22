package dao;

import java.sql.ResultSet;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

import model.Register;
import model.RegisterSite;


public class RegisterDao extends ConnectionDao{


	ConnectionDao connectiondao=new ConnectionDao();

	public int validateRegister(Register register) {
		int i=0;
		con=myConnection();


		try{
			callablestatement=(CallableStatement) con.prepareCall("{call Register1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)};");
			callablestatement.setLong(1,register.getAadharNO());
			callablestatement.setString(2,register.getFirst_name());
			callablestatement.setString(3,register.getMiddle_name());
			callablestatement.setString(4,register.getLast_name());
			callablestatement.setString(5,register.getGender());
			callablestatement.setString(6,register.getDate_of_birth());
			callablestatement.setString(7,register.getAddress());
			callablestatement.setString(8,register.getCity());
			callablestatement.setString(9,register.getState());
			callablestatement.setString(10,register.getCountry());
			callablestatement.setInt(11,register.getZip_code());
			callablestatement.setLong(12,register.getMobile_number());
			callablestatement.setString(13,register.getPan_card_number());
			callablestatement.setString(14,register.getUsername());
			callablestatement.setString(15,register.getPassword());
			callablestatement.setString(16,register.getPassword());

			i=callablestatement.executeUpdate();

			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return i;

	}
}