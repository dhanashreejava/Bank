package model;

import java.util.SplittableRandom;

public class OtpGeneration {
	public static void main(String[] args) {
		System.out.println(OtpGeneration.generateotp(6));

	}
	public static String generateotp(int otpLength)
	{
		SplittableRandom splittableRandom = new SplittableRandom();
		StringBuilder sb=new StringBuilder();

		for(int i=0;i<otpLength;i++)
		{
			sb.append(splittableRandom.nextInt(5,10));
		}
		return sb.toString();
	}
}