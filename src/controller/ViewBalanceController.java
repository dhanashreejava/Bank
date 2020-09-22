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
import javax.servlet.http.HttpSession;

import dao.ViewBalanceDao;
import model.ViewBalanceModel;


/**
 * Servlet implementation class ViewBalanceController
 */
@WebServlet("/ViewBalanceController")
public class ViewBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBalanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("In controller");
		   HttpSession session=request.getSession(false);  
		    long accontno=(long)session.getAttribute("uname"); 
		    ViewBalanceModel  viewBalanceModel =new  ViewBalanceModel();
		    viewBalanceModel.setViewBalance(accontno);
		   // ViewBalanceDao viewBalancedao=new   ViewBalanceDao();
		    ResultSet rs;
		    PrintWriter out=response.getWriter();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://aws-bank.cckb6vdu9n2z.us-east-2.rds.amazonaws.com:3306/Bank?characterEncoding=utf8&useSSL=false&useUnicode=true","root","root12345");
				System.out.println("Connection :"+con);
				PreparedStatement  ps=con.prepareStatement("select Amount from Bank.saving where accountnumber='"+accontno+"'");
				rs=ps.executeQuery();
				out.println("<html><body><table border='3' height='100'><td>Balalnce</td></td>");
				while(rs.next())
				{
					out.print("<tr><td>"+rs.getString(1)+"</td></tr>");
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
