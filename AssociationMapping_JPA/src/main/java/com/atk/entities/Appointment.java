package com.atk.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
    "appointmentId",
    "patientName",
    "patientAge",
    "appointmentDate",
    "appointmentTime",
    "reason",
    "doctor"
})

@Entity
@Data
@NoArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;

	@NotBlank
	private String patientName;

	private int patientAge;

	@FutureOrPresent
	@NotNull
	private LocalDate appointmentDate;

	@NotNull
	private LocalTime appointmentTime;

	@NotBlank
	private String reason;

	@ManyToOne
	@JoinColumn(name = "doctor_Id", nullable = false)
//	@JsonIgnore
	private Doctor doctor;

}
