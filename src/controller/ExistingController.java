package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExitingController
 */
@WebServlet("/ExistingController")
public class ExistingController extends HttpServlet {


	ResultSet rs=null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://aws-bank.cckb6vdu9n2z.us-east-2.rds.amazonaws.com:3306/Bank?characterEncoding=utf8&useSSL=false&useUnicode=true","root","root12345");
			System.out.println("Connection :"+con);
			PreparedStatement  ps=con.prepareStatement("select * from AddBeneficiary");
			rs=ps.executeQuery();
			out.println("<html><body><table border='3' height='100'><td>AccountholderName</td><td>AccountNumber</td><td>Ifsc</td><td>PAY</td>");
			while(rs.next())
			{
				out.print("<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getInt(2)+"</td>"+"<td>"+rs.getInt(3)+"</td>"+"<td><a href='paymentDetail.jsp'>PAY</a></td></tr>");
			}			
			out.println("</table></body></html>");

		}
		catch(Exception e){
			System.out.println(e);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
