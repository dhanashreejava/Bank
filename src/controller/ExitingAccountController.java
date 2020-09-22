package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExistingDao;
import model.AccountRegister;
import model.ExistingModel;

/**
 * Servlet implementation class ExitingAccountController
 */
@WebServlet("/ExitingAccountController")
public class ExitingAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitingAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String accountType1=request.getParameter("accountType");
		long accountNumber=Long.parseLong(request.getParameter("accountNumber"));
		 HttpSession session=request.getSession();  
	     session.setAttribute("uname",accountNumber); 
	    ExistingModel existingmodel=new  ExistingModel();
	    existingmodel.setAccountNumber(accountNumber);
	    existingmodel.setAccounttype(accountType1);
	    ExistingDao  existingdao=new ExistingDao();
	   String i=existingdao.validateAccount(existingmodel);
	   if(i=="true")
	   {
		  response.sendRedirect("dashboard.jsp"); 
	   }
	   else
	   {
			  response.sendRedirect("accountRegister.jsp"); 

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
