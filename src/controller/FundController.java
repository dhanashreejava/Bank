package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FundDao;
import dao.ProfilePasswordDao;
import model.AccountRegister;
import model.Fund;
import model.ProfilePasswordModel;
import model.TransactionTypeModel;

@WebServlet("/FundController")
public class FundController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FundController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double  gSTAmount;
		double amountTotal=0;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(false);  
		long accontno=(long)session.getAttribute("uname"); 
		String password=request.getParameter("password");
		ProfilePasswordModel profilepasswordmodel=new ProfilePasswordModel();
		profilepasswordmodel.setAccountNumber(accontno);
		profilepasswordmodel.setPassword(password);
		ProfilePasswordDao profilepassworddao=new ProfilePasswordDao();
		int k=profilepassworddao.checkpassword(profilepasswordmodel);
		if(k>=1) {
			long accountBeniNumber=Long.parseLong(request.getParameter("accoutBenifinumber"));
			long amount=Long.parseLong(request.getParameter("amt"));
			String transactionType=request.getParameter("trasactiontype");
			Calendar calendar = new GregorianCalendar();  
			int hour=calendar.get(Calendar.HOUR_OF_DAY);
			System.out.println("current time"+hour);
			String am_pm = null;
			if(hour >=10) {
				am_pm = "AM";  
				System.out.println( "welcome AM" );   
			}      
			else{   
				am_pm = "PM";   
				if(hour<6)   
					System.out.println( "welcome PM" );   
			}   
			if(transactionType.equals("neft"))
			{
				System.out.println("In NEFT");
				double gst=2.5;
				if(am_pm.equals("AM"))
				{
					if(amount >=0 && amount <=2500000) {
						System.out.println("Use NEFT");
						gSTAmount = (amount * gst )/100;
						amountTotal=gSTAmount+amount ;
						System.out.println("You have to pay" +amountTotal);
						Fund fund=new Fund();
						fund.setAccNo(accontno);
						fund.setAccountBiniNumber(accountBeniNumber);
						fund.setAmount(amountTotal);
						FundDao funddao=new FundDao();
						int i=funddao.fundTransfer(fund);
						if(i<=1)
						{
							response.sendRedirect("dashboard.jsp");
						}
						else {
							response.sendRedirect("index.jsp");
						}
					}
					else {
						System.out.println("amout is wrong"+amount);
					}
				}
				else {
					System.out.println("not NEFT");
				}
			}
			if(transactionType.equals("rtgs"))
			{
				if(am_pm.equals("AM"))
				{
					double gst=25;
					if(amount >=200000 && amount <=2500000) {
						System.out.println("Use NEFT");
						gSTAmount = (amount * gst )/100;
						amountTotal=gSTAmount+amount ;
						System.out.println("You have to pay" +amountTotal);
						Fund fund=new Fund();
						fund.setAccNo(accontno);
						fund.setAccountBiniNumber(accountBeniNumber);
						fund.setAmount(amountTotal);
						FundDao funddao=new FundDao();
						int i=funddao.fundTransfer(fund);
						if(i<=1)
						{
							response.sendRedirect("dashboard.jsp");
						}
						else {
							response.sendRedirect("index.jsp");
						}
					}
					else {
						System.out.println("amout is wrong"+amount);
					}
				}
				else {
					System.out.println("not NEFT");
				}
			}
			if(transactionType.equals("imps"))
			{
				double gst=25;
				if(amount >=0 && amount <=200000) {
					System.out.println("Use NEFT");
					gSTAmount = (amount * gst )/100;
					amountTotal=gSTAmount+amount ;
					System.out.println("You have to pay" +amountTotal);
					Fund fund=new Fund();
					fund.setAccNo(accontno);
					fund.setAccountBiniNumber(accountBeniNumber);
					fund.setAmount(amountTotal);
					FundDao funddao=new FundDao();
					int i=funddao.fundTransfer(fund);
					if(i<=1)
					{
						response.sendRedirect("dashboard.jsp");
					}
					else {
						response.sendRedirect("index.jsp");
					}
				}
				else {
					System.out.println("amout is wrong"+amount);
				}
			}	
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
