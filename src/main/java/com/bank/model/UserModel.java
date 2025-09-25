package com.bank.model;

public class UserModel {

	private String AccountHolderNumber;
	private String BranchId;
	private String BranchName;
	private String AccountHolderName;
	private String AccountHolderEmail;
	private String AccPassword;
	private String AccountType;
	private double Balance;
	private double Amount;
	private boolean status;
	
	public String getAccountHolderName() {
		return AccountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}

	public String getAccountHolderNumber() {
		return AccountHolderNumber;
	}

	public void setAccountHolderNumber(String accountHolderNumber) {
		 AccountHolderNumber = accountHolderNumber;
	}

	public String getAccPassword() {
		return AccPassword;
	}

	public void setAccPassword(String accPassword) {
		AccPassword = accPassword;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		 AccountType = accountType;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getBranchId() {
		return BranchId;
	}

	public void setBranchId(String branchId) {
		BranchId = branchId;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	

	public String getAccountHolderEmail() {
		return AccountHolderEmail;
	}

	public void setAccountHolderEmail(String accountHolderEmail) {
		AccountHolderEmail = accountHolderEmail;
	}

	@Override
	public String toString() {
		return "UserModel [AccountHolderName=" + AccountHolderName + ", AccountHolderNumber=" + AccountHolderNumber
				+ ", AccPassword=" + AccPassword + ", AccountType=" + AccountType + ", Balance=" + Balance + ", Amount="
				+ Amount + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
