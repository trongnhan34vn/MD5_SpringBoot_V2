package com.example.md5_ss18_baitap.dto.request;

public class SignInForm {
    private String email;
    private String password;

    public SignInForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SignInForm() {
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
}