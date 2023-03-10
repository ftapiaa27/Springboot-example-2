package com.amigoscode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "nombre")
    private String name;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "age")
    private Integer age;

    @Basic
    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    private boolean enabled;

// MANUALLY ADDED CONSTRUCTORS, SETTERS AND GETTERS --------------------------------------------------
//    public Customer(Integer id, String name, String email, Integer age, String password) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.password = password;
//    }
//
//    public Customer() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
}
