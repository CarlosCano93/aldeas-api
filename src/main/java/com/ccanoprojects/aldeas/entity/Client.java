package com.ccanoprojects.aldeas.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "clients")
public class Client {

	public enum RequestStatus {
		PENDING, PAYMENT_PENDING, ACEPTED, REJECTED, INACTIVE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@Column(name = "name", length = 60)
	private String name;

	@Column(name = "last_name", length = 60)
	private String lastName;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "telephone", length = 20)
	private String telephone;

	@Column(name = "nationality", length = 60)
	private String nationality;

	@Column(name = "education", length = 100)
	private String education;

	@Column(name = "message", length = 2000)
	private String message;

	@Column(name = "volunteer_experience", length = 2000)
	private String volunteerExperience;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status")
	private RequestStatus status;

	@Column(name = "plan")
	private String plan;

	@Column(name = "how_know_us")
	private String howKnowUs;

	@Column(name = "spanish_level")
	private String spanishLevel;

	@Column(name = "created")
	private Timestamp created;

	@UpdateTimestamp
	@Column(name = "updated")
	private Timestamp updated;
}
