package com.capgemini.project.bean;

import java.util.ArrayList;

public class BankDetails {

	private String name;
	private String emailid;
	private int age;
	private char gender;
	private long phoneno;
	private long id;
	private String pwd;
	private double amt;
	private ArrayList<String> transaction = new ArrayList<>();
	
	@Override
	public String toString() {
		return "BankDetails [name=" + getName() + ", age=" + getAge() + ", gender=" + getGender() + ", amt=" + getAmt()
				+ "]";
	}

	

	public ArrayList<String> getTransaction() {
		return this.transaction;
	}

	public void setTransaction(String trans) {
		this.transaction.add(trans);
	}

	public BankDetails() {
	}

	public BankDetails(String name, String emailid, int age, char gender, long phoneno, long id, String pwd,
			double amt) {
		super();
		this.name = name;
		this.emailid = emailid;
		this.age = age;
		this.gender = gender;
		this.phoneno = phoneno;
		this.id = id;
		this.pwd = pwd;
		this.amt = amt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd2) {
		this.pwd = pwd2;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

}
