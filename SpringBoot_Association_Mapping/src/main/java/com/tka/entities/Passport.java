package com.tka.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PassPorts")
public class Passport {

	@Id
	private int pass_Id;
	
	@Column(nullable = false, unique = true)
	private String pass_Number;
	
	private String country;

	public int getPass_Id() {
		return pass_Id;
	}

	public void setPass_Id(int pass_Id) {
		this.pass_Id = pass_Id;
	}

	public String getPass_Number() {
		return pass_Number;
	}

	public void setPass_Number(String pass_Number) {
		this.pass_Number = pass_Number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
