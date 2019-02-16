package com.ccanoprojects.aldeas.domain.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@Entity
public class Customer {

    public Customer() {
    }

    public Customer(int id, String name, String lastName, String email, Date birthday, String telephone, String nationality, String education, String message, String volunteerExperience, RequestStatus status, String plan, String howKnowUs, String spanishLevel, Timestamp created, Timestamp updated) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.telephone = telephone;
        this.nationality = nationality;
        this.education = education;
        this.message = message;
        this.volunteerExperience = volunteerExperience;
        this.status = status;
        this.plan = plan;
        this.howKnowUs = howKnowUs;
        this.spanishLevel = spanishLevel;
        this.created = created;
        this.updated = updated;
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
