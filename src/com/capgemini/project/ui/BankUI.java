package com.capgemini.project.ui;


import java.util.Random;
import java.util.Scanner;

import com.capgemini.project.bean.BankDetails;
import com.capgemini.project.service.BankService;

public class BankUI {
	private static char ch;
	private static int num;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		BankService bs = new BankService();
		System.out.println("*********Welcome to WeCare Bank***********");
		System.out.println("------------------------------------------");
		System.out.println("Create account::::::");
		do {
			BankDetails bk = new BankDetails();
			
			System.out.println("Name: ");
			String name = scan.nextLine();
			bk.setName(name);
			
			System.out.println("Email-ID: ");
			String emailid = scan.nextLine();
			bk.setEmailid(emailid);
			System.out.println("Age: ");
			int age = scan.nextInt();
			scan.nextLine();
			bk.setAge(age);
			System.out.println("Gender(M/F): ");
			char gender = scan.next().charAt(0);
			scan.nextLine();
			bk.setGender(gender);
			System.out.println("10-Digit Phone Number: ");
			long phoneno = scan.nextLong();
			scan.nextLine();
			bk.setPhoneno(phoneno);
			System.out.println("Password for your account: ");
			String pwd = scan.nextLine();
			bk.setPwd(pwd);
			System.out.println("Amount: ");
			double amt = scan.nextDouble();
			scan.nextLine();
			bk.setAmt(amt);
			if(bs.validateAccount(emailid)) {
				System.out.println("EmailId of another account is same, please enter different emailid:");
				System.out.println("Email-ID: ");
				emailid = scan.nextLine();
				bk.setEmailid(emailid);
			}
			Random rn = new Random();
			long id = Math.abs(rn.nextInt() / 10000000);
			bk.setId(id);
			System.out.println("Your Bank Account Id: " + bk.getId());
			bs.saveDetails(id, bk);
			System.out.println("");
			System.out.println("Account Registerd Successfully.........");
			Thread.sleep(1000);
			System.out.println("Do You want to create more account(Y/N): ");
			ch = scan.next().charAt(0);
			scan.nextLine();
		} while (ch == 'Y' || ch == 'y');
		long id, secid = 0;
		double amt = 0;
		String pwd = "";
		while (true) {
			System.out.println("Enter the corresponding number of your Bank operation option....");
			for (BankOps number : BankOps.values()) {
				System.out.println(number.getNumber() + " - " + number);
			}
			num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.print("Enter id of your account: ");
				id = scan.nextLong();
				System.out.println(bs.showBalance(id));
				Thread.sleep(1000);
				break;
			case 2:
				System.out.print("Enter id of your account: ");
				id = scan.nextLong();
				System.out.print("Enter the amount you want to deposit: ");
				amt = scan.nextDouble();
				System.out.println(bs.depositAmt(id, amt));
				Thread.sleep(1000);
				break;
			case 3:
				System.out.println("Enter id of your account: ");
				id = scan.nextLong();
				scan.nextLine();
				System.out.println("Enter your password: ");
				pwd = scan.nextLine();
				System.out.print("Enter the amount you want to withdraw: ");
				amt = scan.nextDouble();
				System.out.println(bs.withdraw(id, pwd, amt));
				Thread.sleep(1000);
				break;
			case 4:
				System.out.println("Enter id of your account: ");
				id = scan.nextLong();
				scan.nextLine();
				System.out.println("Enter your password: ");
				pwd = scan.nextLine();
				System.out.println("Enter id of his/her account: ");
				secid = scan.nextLong();
				System.out.print("Enter the amount you want to Transfer: ");
				amt = scan.nextDouble();
				if (id == secid)
					System.out.println("Id of his/her account cannot be same to transfering account.....");
				else
					System.out.println(bs.transferAmt(id, pwd, secid, amt));
				Thread.sleep(1000);
				break;
			case 5:
				System.out.println("Enter id of your account: ");
				id = scan.nextLong();
				scan.nextLine();
				System.out.println("Enter your password: ");
				pwd = scan.nextLine();
				bs.printTransaction(id, pwd);
				Thread.sleep(1000);
				break;
			case 6:
				bs.showAccounts();
				Thread.sleep(1000);
				break;
			case 0:
				System.out.println("Thank You using WeCare Bank Service");
				System.exit(0);
				break;
			default:
				System.out.println("Enter proper number corresponding to numbers.");
			}
		}

	}
}
