package com.capgemini.project.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.project.bean.BankDetails;

public class BankServiceDao implements IBankServiceDao {
	
	static Map<Long,BankDetails> map = new HashMap<>();
	@Override
	public void insertDetails(long id, BankDetails bd) {
		map.put(id, bd);

	}
	@Override
	public BankDetails searchID(long id) {
		if(map.containsKey(id))
			return map.get(id);
		else
			return null;
	}
	
	@Override
	public void getDetails() {
		for(Object ob: map.entrySet()) {
			Map.Entry me = (Map.Entry)ob;
			System.out.println(((BankDetails)me.getValue()).toString());
		}
	}
	public boolean validateFromAccount(String emailId) {
		for(Object ob: map.entrySet()) {
			Map.Entry me = (Map.Entry)ob;
			if(((BankDetails)me.getValue()).getEmailid()!=emailId) {
				return true;
			}
		}
		return false;
	}

}
