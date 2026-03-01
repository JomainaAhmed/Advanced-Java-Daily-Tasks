package com.OTM;

	import java.util.List;

	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToMany;

	@Entity
	public class Bank {
		@Id
		private int id;
		private String name;
		private String location;
		
		@OneToMany(mappedBy = "bank", cascade = jakarta.persistence.CascadeType.ALL)
		private List<Account> accounts;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public List<Account> getAccounts() {
			return accounts;
		}
		public void setAccounts(List<Account> accounts) {
			this.accounts = accounts;
		}

		public Bank() {
			
		}
		
	}