package com.OTM;

import java.util.List;

public interface BankAccountCRUD {
		
	void saveBank(Bank bank);
		
	void updateBank(int id);
		
	Bank findBankByID(int id);
		
	Bank findBankByName(String name);
		
	void assignAccountsToBank(int bankId, Account newAccount);
		
	void assignAccountsToBank(int bankId, List<Account> accounts);
		
	List<Account> findAllAccountsInBank(int bankId);
}
