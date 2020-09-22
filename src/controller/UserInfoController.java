package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import dao.UserInfoDao;
import model.AadharCard;

@WebServlet("/UserInfoController")
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		AadharCard aadharcard=new AadharCard();

		UserInfoDao userinfodao=new	UserInfoDao();
		HttpSession httpSession=request.getSession();
		long adhaar_no=Long.parseLong(httpSession. getAttribute("aadhar").toString());
		aadharcard.setAadhar_card_number(adhaar_no);

		String i=userinfodao.userInfo(aadharcard);

		if(i=="true")
		{
			response.sendRedirect("register.jsp");
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
