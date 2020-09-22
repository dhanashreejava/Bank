package dao;

import model.ViewBalanceModel;

public class ViewBalanceDao extends ConnectionDao{
	ConnectionDao connectionDao=new ConnectionDao();
	int i=0;
	public int viewBalance(ViewBalanceModel viewBalanceModel)
	{
		try {
			long accno=viewBalanceModel.getViewBalance();
			String sql="select Amount from Bank.saving where accountnumber='"+accno+"'";
			preparedstatement  = con.prepareStatement(sql);
			i= preparedstatement.executeUpdate();
			if(i<1)
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


