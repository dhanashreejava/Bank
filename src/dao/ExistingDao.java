package dao;

import java.sql.ResultSet;

import model.ExistingModel;
import model.RegisterSite;

public class ExistingDao extends ConnectionDao{
	ConnectionDao connectiondao=new ConnectionDao();
	public String validateAccount(ExistingModel existingmodel) {
		con=myConnection();
        String accountType=existingmodel.getAccounttype();
        System.out.println(accountType);
		String sql="select accountnumber from Bank.saving where accountnumber=?";
		try{
			preparedstatement=con.prepareStatement(sql);

			preparedstatement.setLong(1, existingmodel.getAccountNumber());

			ResultSet rs=preparedstatement.executeQuery();

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
