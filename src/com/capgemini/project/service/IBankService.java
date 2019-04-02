package com.capgemini.project.service;

import com.capgemini.project.bean.BankDetails;

public interface IBankService {
	public void saveDetails(long id, BankDetails bd);

	public String showBalance(long id);

	String depositAmt(long id, double amt);

	String withdraw(long id, String pwd, double amt);

	String transferAmt(long id, String pwd, long secid, double amt);

	void printTransaction(long id, String pwd);

	void showAccounts();

	boolean validateAccount(String emailid);
}
