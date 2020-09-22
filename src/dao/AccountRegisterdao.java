package dao;

import com.mysql.jdbc.Statement;

import model.AccountRegister;
import model.Register;

public class AccountRegisterdao extends ConnectionDao {
	public int validateRegister(AccountRegister accountRegister) {
		int i=0;
		con=myConnection();
		try{
			System.out.println("saving dao "+accountRegister.getAccount_type());
			String s=accountRegister.getAccount_type();
			System.out.println(s);
			if(s.equals("saving")){
				preparedstatement=con.prepareStatement("insert into Bank.saving (accounttype,branchname,aadharcardnumber,firstname,middlename,lastname,gender,dateofBirth,address,city,state,country,zipcode,mobilenumber,pancard,username,password) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				preparedstatement.setString(1, accountRegister.getAccount_type());
				preparedstatement.setString(2, accountRegister.getBranch_name());
				preparedstatement.setLong(3,accountRegister.getAadhar_card_number());
				preparedstatement.setString(4, accountRegister.getFirst_name());
				preparedstatement.setString(5, accountRegister.getMiddle_name());
				preparedstatement.setString(6,accountRegister.getLast_name());
				preparedstatement.setString(7, accountRegister.getGender());
				preparedstatement.setString(8, accountRegister.getDate_of_birth());
				preparedstatement.setString(9, accountRegister.getAddress());
				preparedstatement.setString(10, accountRegister.getCity());
				preparedstatement.setString(11, accountRegister.getState());
				preparedstatement.setString(12, accountRegister.getCountry());
				preparedstatement.setInt(13, accountRegister.getZip_code());
				preparedstatement.setLong(14,accountRegister.getMobile_number());
				preparedstatement.setString(15, accountRegister.getPan_card_number());
				preparedstatement.setString(16,accountRegister.getUsername());
				preparedstatement.setString(17, accountRegister.getPassword());
				i=preparedstatement.executeUpdate();
			}
			else {
				    String sql="insert into Bank.current values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					preparedstatement=con.prepareStatement(sql);
					preparedstatement.setString(1, accountRegister.getAccount_type());
					preparedstatement.setString(2, accountRegister.getBranch_name());
					preparedstatement.setLong(3,accountRegister.getAadhar_card_number());
					preparedstatement.setString(4, accountRegister.getFirst_name());
					preparedstatement.setString(5, accountRegister.getMiddle_name());
					preparedstatement.setString(6,accountRegister.getLast_name());
					preparedstatement.setString(7, accountRegister.getGender());
					preparedstatement.setString(8, accountRegister.getDate_of_birth());
					preparedstatement.setString(9, accountRegister.getAddress());
					preparedstatement.setString(10, accountRegister.getCity());
					preparedstatement.setString(11, accountRegister.getState());
					preparedstatement.setString(12, accountRegister.getCountry());
					preparedstatement.setInt(13, accountRegister.getZip_code());
					preparedstatement.setLong(14,accountRegister.getMobile_number());
					preparedstatement.setString(15, accountRegister.getPan_card_number());
					preparedstatement.setString(16,accountRegister.getUsername());
					preparedstatement.setString(17, accountRegister.getPassword());
					i=preparedstatement.executeUpdate();	
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return i;

	}


}
