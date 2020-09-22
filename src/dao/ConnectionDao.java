package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.CallableStatement;

public class ConnectionDao {
	protected Connection con;
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://aws-bank.cckb6vdu9n2z.us-east-2.rds.amazonaws.com:3306/Bank?characterEncoding=utf8&useSSL=false&useUnicode=true";
	protected PreparedStatement preparedstatement;
	protected CallableStatement callablestatement;
	private String username="root";
	protected ResultSet rs;

	private String password="root12345";

	public Connection myConnection()
	{
		try{
			Class.forName(driver).newInstance();
			con=DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}


}