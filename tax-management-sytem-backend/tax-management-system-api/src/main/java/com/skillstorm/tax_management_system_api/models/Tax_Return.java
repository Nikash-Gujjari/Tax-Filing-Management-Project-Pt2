package com.skillstorm.tax_management_system_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Tax_Return {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int tax_return_id;
	
	@Column
	private String filing_status;
	
	@ManyToOne
	@JoinColumn(name="cpa", referencedColumnName = "cpa_id")
	@JsonIgnoreProperties("tax_return")
	private Cpa cpa;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Taxpayer> taxpayer;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Form> forms;
	
	
	public Tax_Return() {
		super();
	}


	public Tax_Return(int tax_return_id, String filing_status, Cpa cpa, List<Taxpayer> taxpayer, List<Form> forms) {
		super();
		this.tax_return_id = tax_return_id;
		this.filing_status = filing_status;
		this.cpa = cpa;
		this.taxpayer = taxpayer;
		this.forms = forms;
	}


	public int getTax_return_id() {
		return tax_return_id;
	}


	public void setTax_return_id(int tax_return_id) {
		this.tax_return_id = tax_return_id;
	}


	public String getFiling_status() {
		return filing_status;
	}


	public void setFiling_status(String filing_status) {
		this.filing_status = filing_status;
	}


	public Cpa getCpa() {
		return cpa;
	}


	public void setCpa(Cpa cpa) {
		this.cpa = cpa;
	}


	public List<Taxpayer> getTaxpayer() {
		return taxpayer;
	}


	public void setTaxpayer(List<Taxpayer> taxpayer) {
		this.taxpayer = taxpayer;
	}


	public List<Form> getForms() {
		return forms;
	}


	public void setForms(List<Form> forms) {
		this.forms = forms;
	}


	@Override
	public String toString() {
		return "Tax_Return [tax_return_id=" + tax_return_id + ", filing_status=" + filing_status + ", cpa=" + cpa
				+ ", taxpayer=" + taxpayer + ", forms=" + forms + "]";
	}

}

