package com.capgemini.project.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.capgemini.project.bean.BankDetails;
import com.capgemini.project.dao.BankServiceDao;

public class BankService implements IBankService {
	static BankServiceDao bsd = new BankServiceDao();
	static DateTimeFormatter dt =DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm");
	
	@Override
	public void saveDetails(long id, BankDetails bd) {

		bsd.insertDetails(id, bd);
	}

	@Override
	public String showBalance(long id) {
		BankDetails bd = bsd.searchID(id);
		if (bd != null) {
			return "ID: " + id + " Balance: " + bd.getAmt();
		} else {
			return "This ID Data does not contain";
		}
	}

	@Override
	public String depositAmt(long id, double amt) {
		LocalDateTime now = LocalDateTime.now();
		BankDetails bd = bsd.searchID(id);
		if (bd != null) {
			double newamt = amt + bd.getAmt();
			bd.setAmt(newamt);
			String trans = "Deposited Amount: "+amt+" at "+now+", Balance Amt: "+newamt;
			bd.setTransaction(trans);
			return "ID: " + id + " Balance: " + bd.getAmt();
		} else {
			return "This ID Data does not contain";
		}
	}

	@Override
	public String withdraw(long id, String pwd, double amt) {
		LocalDateTime now = LocalDateTime.now();
		BankDetails bd = bsd.searchID(id);
		String cnfrmPwd = bd.getPwd();
		double balanceamt = bd.getAmt();
		if (bd != null && (cnfrmPwd.equals(pwd)) && (balanceamt > amt)) {
			double newamt = balanceamt - amt;
			bd.setAmt(newamt);
			String trans = "Withdrawal Amount: "+amt+" at "+now+", Balance Amt: "+newamt;
			bd.setTransaction(trans);
			return "ID: " + id + " Balance: " + bd.getAmt();
		} else {
			return "ID or Password is wrong or Balance Amount is Low.";
		}
	}

	@Override
	public String transferAmt(long id, String pwd, long secid, double amt) {
		LocalDateTime now = LocalDateTime.now();
		BankDetails bd = bsd.searchID(id);
		String cnfrmPwd = bd.getPwd();
		BankDetails secbd = bsd.searchID(secid);
		double balanceamt = bd.getAmt();
		double secbalanceamt = secbd.getAmt();
		if (bd != null && secbd != null && (cnfrmPwd.equals(pwd)) && (balanceamt > amt)) {
			double newamt = balanceamt - amt;
			bd.setAmt(newamt);
			double secnewamt = secbalanceamt + amt;
			secbd.setAmt(secnewamt);
			String trans = "Withdrawal Amount: "+amt+" at "+now+", Balance Amt: "+newamt;
			bd.setTransaction(trans);
			String sectrans = "Deposited Amount: "+amt+" at "+now+", Balance Amt: "+secnewamt;
			secbd.setTransaction(sectrans);
			return "ID: " + id + " Balance: " + bd.getAmt()+"\n"+"ID: " + secid + " Balance: " + secbd.getAmt();
		} else {
			return "ID or Password is wrong or Balance Amount is Low.";
		}
	}
	@Override
	public void printTransaction(long id, String pwd) {
		BankDetails bd = bsd.searchID(id);
		String cnfrmPwd = bd.getPwd();
		if (bd != null && (cnfrmPwd.equals(pwd))){
			ArrayList<String> list = bd.getTransaction();
			System.out.println("Transactions of id: ");
			list.forEach(System.out::println);
		}
		else {
			System.out.println("ID or Password is wrong");
		}
		
	}
	@Override
	public void showAccounts() {
		bsd.getDetails();
		
	}
	@Override
	public boolean validateAccount(String emailid) {
		boolean flag = bsd.validateFromAccount(emailid);
		return flag;
	}
	
	
}
