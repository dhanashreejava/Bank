package dao;

import java.sql.SQLException;

import model.ProfilePasswordModel;

public class ProfilePasswordDao extends ConnectionDao{
	ConnectionDao connectiondao=new ConnectionDao();
	public int checkpassword(ProfilePasswordModel profilepasswordmodel)
	{
		connectiondao.myConnection();
		int i=0;
		String sql="select password from Bank.saving where password=?";
		try {
			preparedstatement=con.prepareStatement(sql);
			preparedstatement.setString(1,profilepasswordmodel.getPassword());
			i=preparedstatement.executeUpdate();
			if(i<=1)
			{
				i=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
