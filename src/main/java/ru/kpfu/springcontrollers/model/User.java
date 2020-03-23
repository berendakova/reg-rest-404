package ru.kpfu.springcontrollers.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "email", unique = true, nullable = false)
    @Email
    @NotEmpty
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 6)
    @NotEmpty
    private String password;

    @Size(min = 6)
    @NotEmpty
    private String passwordConfirm;

    @Column(name = "country", nullable = false)
    @NotEmpty
    private String country;


    @Column(name = "gender", nullable = false)
    @NotEmpty
    private String gender;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    public User() {
    }

    public User(
            String email,
            String password,
            String country,
            String gender,
            String birthday) {
        this.email = email;
        this.password = password;
        this.country = country;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
