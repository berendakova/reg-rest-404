package ru.kpfu.springcontrollers.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Form {
    @Email
    @NotEmpty
    private String email;

    @Size(min = 6)
    @NotEmpty
    private String password;

    @Size(min = 6)
    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String country;

    @NotEmpty
    private String gender;

    @NotEmpty
    private String birthday;


    public Form(String email,
                String password,
                String confirmPassword,
                String country, String gender,
                String birthday) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.country = country;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Form() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
