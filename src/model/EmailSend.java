package model;

import com.email.durgesh.Email;
public class EmailSend {


	public void sendmail(String mailid,String otp)
	{
		try{
			Email email=new Email("bankproject149@gmail.com","Bank12345");
			email.setFrom("bankproject149@gmail.com","Global Bank");
			email.setSubject("OTP");

			email.setContent("Your OTP is :"+otp, "text/html");
			email.addRecipient(mailid);
			email.send();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
