
package com.skillstorm.tax_management_system_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Cpa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int cpa_id;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@OneToMany(mappedBy = "cpa", cascade=CascadeType.ALL)
	@JsonIgnoreProperties
	private List<Tax_Return> tax_return;
	
	public Cpa() {
		super();
	}

	public Cpa(int cpa_id, String first_name, String last_name, String email, String username, String password,
			String role, List<Tax_Return> tax_return) {
		super();
		this.cpa_id = cpa_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.tax_return = tax_return;
	}

	public int getCpa_id() {
		return cpa_id;
	}

	public void setCpa_id(int cpa_id) {
		this.cpa_id = cpa_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Tax_Return> getTax_return() {
		return tax_return;
	}

	public void setTax_return(List<Tax_Return> tax_return) {
		this.tax_return = tax_return;
	}

	@Override
	public String toString() {
		return "Cpa [cpa_id=" + cpa_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", role=" + role + ", tax_return="
				+ tax_return + "]";
	}
	
	
	
}

