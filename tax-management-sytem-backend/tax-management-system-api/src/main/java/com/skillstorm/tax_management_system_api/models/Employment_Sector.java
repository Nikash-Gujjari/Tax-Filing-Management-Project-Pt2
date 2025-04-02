package com.skillstorm.tax_management_system_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Employment_Sector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int sector_id;
	
	@Column
	private String sector_name;
	
	@OneToOne(mappedBy="employment_sector", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("employment_sector")
	private Taxpayer taxpayer;

	public Employment_Sector(int sector_id, String sector_name, Taxpayer taxpayer) {
		super();
		this.sector_id = sector_id;
		this.sector_name = sector_name;
		this.taxpayer = taxpayer;
	}

	public int getSector_id() {
		return sector_id;
	}

	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}

	public String getSector_name() {
		return sector_name;
	}

	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}

	public Taxpayer getTaxpayer() {
		return taxpayer;
	}

	public void setTaxpayer(Taxpayer taxpayer) {
		this.taxpayer = taxpayer;
	}

	@Override
	public String toString() {
		return "Employment_Sector [sector_id=" + sector_id + ", sector_name=" + sector_name + ", taxpayer=" + taxpayer
				+ "]";
	}

	
	
	
}

