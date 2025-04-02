package com.skillstorm.tax_management_system_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Taxpayer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int taxpayer_id;
	
	@Column
	private String first_name;

	@Column
	private String middle_name;
	
	@Column
	private String last_name;
	
	@Column
	private String social_security_number;
	
	@Column
	private String address;
	
	@Column
	private String date_of_birth;
	
	@Column
	private String bank_account_number;
	
	@Column
	private String bank_routing_number;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employment_sector", referencedColumnName="sector_id")
	@JsonIgnoreProperties("taxpayer")
	private Employment_Sector employment_sector;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnoreProperties("taxpayer")
	private Tax_Return tax_return;

	public Taxpayer(int taxpayer_id, String first_name, String middle_name, String last_name,
			String social_security_number, String address, String date_of_birth, String bank_account_number,
			String bank_routing_number, Employment_Sector employment_sector, Tax_Return tax_return) {
		super();
		this.taxpayer_id = taxpayer_id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.social_security_number = social_security_number;
		this.address = address;
		this.date_of_birth = date_of_birth;
		this.bank_account_number = bank_account_number;
		this.bank_routing_number = bank_routing_number;
		this.employment_sector = employment_sector;
		this.tax_return = tax_return;
	}

	public int getTaxpayer_id() {
		return taxpayer_id;
	}

	public void setTaxpayer_id(int taxpayer_id) {
		this.taxpayer_id = taxpayer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSocial_security_number() {
		return social_security_number;
	}

	public void setSocial_security_number(String social_security_number) {
		this.social_security_number = social_security_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getBank_account_number() {
		return bank_account_number;
	}

	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}

	public String getBank_routing_number() {
		return bank_routing_number;
	}

	public void setBank_routing_number(String bank_routing_number) {
		this.bank_routing_number = bank_routing_number;
	}

	public Employment_Sector getEmployment_sector() {
		return employment_sector;
	}

	public void setEmployment_sector(Employment_Sector employment_sector) {
		this.employment_sector = employment_sector;
	}

	public Tax_Return getTax_return() {
		return tax_return;
	}

	public void setTax_return(Tax_Return tax_return) {
		this.tax_return = tax_return;
	}

	@Override
	public String toString() {
		return "Taxpayer [taxpayer_id=" + taxpayer_id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", social_security_number=" + social_security_number + ", address="
				+ address + ", date_of_birth=" + date_of_birth + ", bank_account_number=" + bank_account_number
				+ ", bank_routing_number=" + bank_routing_number + ", employment_sector=" + employment_sector
				+ ", tax_return=" + tax_return + "]";
	}

	
	
	
}

