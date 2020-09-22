package dao;

import java.sql.*;


import model.AadharCard;

public class UserInfoDao extends ConnectionDao{

	//ConnectionDao connectiondao=new ConnectionDao();


	public String userInfo(AadharCard aadharcard)
	{

		con=myConnection();
		System.out.println(aadharcard.getAadhar_card_number());
		String sql="select * from Bank.aadhar where aadhar_card_number="+aadharcard.getAadhar_card_number();
		try{
			Statement stmt = con.createStatement(); 
			//PreparedStatement ps=con.prepareStatement(sql);
//			ps.setLong(1, aadharcard.getAadhar_card_number());
//			ps.setString(2,aadharcard.getFirst_name());
//			ps.setString(3,aadharcard.getMiddle_name());
//			ps.setString(4,aadharcard.getLast_name());
//			ps.setString(5,aadharcard.getGender());
//			ps.setString(6,aadharcard.getDate_of_birth());
//			ps.setString(7,aadharcard.getAddress());
//			ps.setString(8,aadharcard.getCity());
//			ps.setString(9,aadharcard.getState());
//			ps.setString(10,aadharcard.getCountry());
//			ps.setInt(11,aadharcard.getZip_code());
//			ps.setLong(12,aadharcard.getMobile_number());
//			ps.setString(13,aadharcard.getEmail());
//			ps.setString(14,aadharcard.getPan_card_number());

			ResultSet rs=stmt.executeQuery(sql);


			if(rs.next())
			{
				rs.getLong("aadhar_card_number");
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

