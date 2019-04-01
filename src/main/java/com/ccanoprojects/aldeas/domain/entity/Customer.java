package com.ccanoprojects.aldeas.domain.entity;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

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
