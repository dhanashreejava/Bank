package controller;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDao;
import model.Register;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=request.getSession(false);  
		long aadharNo=(long)session.getAttribute("aadhar");   
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

		Register register=new Register();
		register.setAadharNO(aadharNo);
		register.setFirst_name(firstName);
		register.setMiddle_name(middleName);
		register.setLast_name(lastName);
		register.setGender(gender);
		register.setDate_of_birth(dateOfBirth);
		register.setAddress(address);
		register.setCity(city);
		register.setState(state);
		register.setCountry(country);
		register.setZip_code(zipCode);
		register.setMobile_number(mobNo);
		register.setPan_card_number(panNo);
		register.setUsername(username);
		register.setPassword(password);

		RegisterDao registerdao=new RegisterDao();
		int i=registerdao.validateRegister(register);
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
	
}
