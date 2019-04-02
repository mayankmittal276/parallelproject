package com.capgemini.project.ui;

public enum BankOps {
	Show_Balance(1), Deposit(2), WithDraw(3), Fund_Transfer(4), Print_Transactions(5), Show_Account_Details(6), Exit(0);

	private int number;

	BankOps(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}
}

