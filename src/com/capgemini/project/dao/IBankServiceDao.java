package com.capgemini.project.dao;

import com.capgemini.project.bean.BankDetails;

public interface IBankServiceDao {
	public void insertDetails(long id,BankDetails bd);

	void getDetails();

	BankDetails searchID(long id);
}
