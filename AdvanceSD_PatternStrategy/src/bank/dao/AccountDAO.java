package bank.dao;

import java.util.*;
import bank.domain.Account;

public class AccountDAO implements IAccountDAO {
	Collection<Account> accountList = new ArrayList<Account>();

	@Override
	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		accountList.add(account);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		Account existentAccount = loadAccount(account.getAccountNumber());
		if (existentAccount != null) {
			accountList.remove(existentAccount);
			accountList.add(account);
		}
	}

	@Override
	public Account loadAccount(long accountNumber) {
		// TODO Auto-generated method stub
		for (Account account : accountList) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	@Override
	public Collection<Account> getAccounts() {
		// TODO Auto-generated method stub
		return accountList;
	}

}
