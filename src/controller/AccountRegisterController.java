package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountRegisterdao;
import dao.RegisterDao;
import model.AccountRegister;
import model.Register;

/**
 * Servlet implementation class AccountRegister
 */
@WebServlet("/AccountRegister")
public class AccountRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String accounttype=request.getParameter("acctype");
		String branchname=request.getParameter("branchname");
	    Long   aadharnumber=Long.parseLong(request.getParameter("aadharnumber"));
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String gender=request.getParameter("gender");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		int zipCode=Integer.parseInt(request.getParameter("zipCode"));
		Long mobNo=Long.parseLong(request.getParameter("mobNo"));
		String panNo=request.getParameter("panNo");
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		AccountRegister accountRegister=new AccountRegister();
		accountRegister.setAccount_type(accounttype);
		accountRegister.setBranch_name( branchname);
		accountRegister.setAadhar_card_number(aadharnumber);
		accountRegister.setFirst_name(firstName);
		accountRegister.setMiddle_name(middleName);
		accountRegister.setLast_name(lastName);
		accountRegister.setGender(gender);
		accountRegister.setDate_of_birth(dateOfBirth);
		accountRegister.setAddress(address);
		accountRegister.setCity(city);
		accountRegister.setState(state);
		accountRegister.setCountry(country);
		accountRegister.setZip_code(zipCode);
		accountRegister.setMobile_number(mobNo);
		accountRegister.setPan_card_number(panNo);
		accountRegister.setUsername(username);
		accountRegister.setPassword(password);
	    AccountRegisterdao  accountRegisterdao=new AccountRegisterdao();
		int i=accountRegisterdao.validateRegister(accountRegister);
		if(i>=0)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp");
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
