package com.skillstorm.tax_management_system_api.models;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Form {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int form_id;
	
	@Column
	private String form_name;
	
	@Column
	private String form_type;
	
	@Lob
	@Column
	private Blob form;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnoreProperties("form")
	private Tax_Return tax_return;
	
	public Form() {
		super();
	}

	public Form(int form_id, String form_name, String form_type, Blob form, Tax_Return tax_return) {
		super();
		this.form_id = form_id;
		this.form_name = form_name;
		this.form_type = form_type;
		this.form = form;
		this.tax_return = tax_return;
	}

	public int getform_id() {
		return form_id;
	}

	public void setform_id(int form_id) {
		this.form_id = form_id;
	}

	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}

	public String getForm_type() {
		return form_type;
	}

	public void setForm_type(String form_type) {
		this.form_type = form_type;
	}

	public Blob getForm() {
		return form;
	}

	public void setForm(Blob form) {
		this.form = form;
	}

	public Tax_Return getTax_return() {
		return tax_return;
	}

	public void setTax_return(Tax_Return tax_return) {
		this.tax_return = tax_return;
	}

	@Override
	public String toString() {
		return "Form [form_id=" + form_id + ", form_name=" + form_name + ", form_type=" + form_type
				+ ", form=" + form + ", tax_return=" + tax_return + "]";
	}
	
	

	
	
}


