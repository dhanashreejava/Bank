package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import model.Fund;


public class FundDao extends ConnectionDao {
	ConnectionDao connectiondao=new ConnectionDao();
	java.sql.Statement  stmt = null;
	Connection conn = null;
	int i=0;
	public int fundTransfer(Fund fund) {

		con=myConnection();

		//		String updateSql = "UPDATE Bank.saving"
		//				+ " SET Amount= Amount-50 WHERE  accountnumber = 10110011";		
		try
		{
			long accno=fund.getAccNo();
			System.out.println("In dao"+accno);
			double amt= fund.getAmount();
			long accnoB=fund.getAccountBiniNumber();
			//long accountNo=fund.getAccountBiniNumber();
			String query = "update Bank.saving set Amount=Amount-'"+amt+"' where accountnumber='"+accno+"'";
			String query2="update Bank.saving set Amount=Amount+'"+amt+"'  where accountnumber='"+accnoB+"'";
			preparedstatement  = con.prepareStatement(query2);
			int k=preparedstatement.executeUpdate();
			preparedstatement  = con.prepareStatement(query);
			int i= preparedstatement.executeUpdate();
			if(i<1 && k<1)
				while(rs.next()){
					i=1;
				}
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return i;
	}

}


