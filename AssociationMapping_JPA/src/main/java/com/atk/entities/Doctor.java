package com.atk.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonPropertyOrder({
    "doctorId",
    "doctorName",
    "experience",
    "fees",
    "hospitalName",
    "specialization",
    "appointment"
    
})
@Entity
@Data
@NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	
	@NotBlank
	@Column(length = 50)
	private String doctorName;
	
	@NotBlank
	private String specialization;
	
	@Column(nullable = false)
	private int experience;
	
	private double fees;
	
	@NotBlank
	private String hospitalName;
	
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	private List<Appointment> appointment;	
	
}
