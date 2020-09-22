package model;

public class Fund {
	private long accountBiniNumber;
	private double amountTotal;
	private long accNo;
	public long getAccountBiniNumber() {
		return accountBiniNumber;
	}
	public void setAccountBiniNumber(long accountBiniNumber) {
		this.accountBiniNumber = accountBiniNumber;
	}
	public double getAmount() {
		return amountTotal;
	}

	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public void setAmount(double amountTotal) {
		this.amountTotal = amountTotal;
		
	}

	
}
