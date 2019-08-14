package bank.domain;

import java.util.*;

public class Account {
	private String type;
	private long accountNumber;
	private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	private Customer customer;
	private IInterestStrategy interestStrategy;

	public Account(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(Collection<AccountEntry> entryList) {
		this.entryList = entryList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public IInterestStrategy getInterestStrategy() {
		return interestStrategy;
	}

	public void setInterestStrategy(IInterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		this.entryList.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		this.entryList.add(entry);
	}

	public void addEntry(AccountEntry entry) {
		this.entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, "" + toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, "" + toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		entryList.add(fromEntry);
		toAccount.addEntry(toEntry);
	}

	public void addInterest() {
		System.out.println("Add interest on account of type:" + this.type);
		System.out.println("Old balance = " + this.getBalance());
		double interest = interestStrategy.computeInterest(this.getBalance());
		AccountEntry entry = new AccountEntry(new Date(), interest, "interest", "", "");
		entryList.add(entry);
		System.out.println("new balance = " + this.getBalance());
	}
}
