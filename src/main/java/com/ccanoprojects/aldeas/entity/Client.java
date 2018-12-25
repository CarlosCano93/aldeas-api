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

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "clients")
public class Client {

	public enum RequestStatus {
		PENDING, PAYMENTPENDING, ACEPTED, REJECTED, INACTIVE
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

	@Column(name = "nacionality", length = 60)
	private String nacionality;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVolunteerExperience() {
		return volunteerExperience;
	}

	public void setVolunteerExperience(String volunteerExperience) {
		this.volunteerExperience = volunteerExperience;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public String getSpanishLevel() {
		return spanishLevel;
	}

	public void setSpanishLevel(String spanishLevel) {
		this.spanishLevel = spanishLevel;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getHowKnowUs() {
		return howKnowUs;
	}

	public void setHowKnowUs(String howKnowUs) {
		this.howKnowUs = howKnowUs;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", birthday="
				+ birthday + ", telephone=" + telephone + ", nacionality=" + nacionality + ", education=" + education
				+ ", message=" + message + ", volunteerExperience=" + volunteerExperience + ", status=" + status
				+ ", plan=" + plan + ", howKnowUs=" + howKnowUs + ", spanishLevel=" + spanishLevel + ", created="
				+ created + ", updated=" + updated + "]";
	}

}
