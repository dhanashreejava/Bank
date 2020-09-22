package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AadharVerification;
import model.AadharCard;
import model.EmailSend;
import model.OtpGeneration;
import model.RegisterSite;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/RegisterSiteController")
public class RegisterSiteController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterSiteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpsession=request.getSession();

		String email=request.getParameter("email");
		String otp=new OtpGeneration().generateotp(6);
		long aadharCardNumber=Long.parseLong(request.getParameter("aadhar"));
		HttpSession session=request.getSession();  
	     session.setAttribute("aadhar",aadharCardNumber); 
		EmailSend e =new EmailSend();
		e.sendmail(email,otp);
		RegisterSite l=new RegisterSite();
		l.setAadharCardNumber(aadharCardNumber);
		l.setEmail(email);
		l.setOtp(otp);
		AadharVerification AadharVerification=new AadharVerification();
		String i=AadharVerification.validatedata(l);
		if(i.equals("true"))
		{
			httpsession.setAttribute("otp", otp);
			httpsession.setAttribute("aadhar", aadharCardNumber);
			response.sendRedirect("registerSite.jsp");
			//	
		}
		else 
		{
			response.sendRedirect("index.jsp");
		}

	}







	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
