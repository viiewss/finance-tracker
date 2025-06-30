package com.mahirmohtasin.financetracker.dto;

public class UserRegisterRequest {
    private String email;
    private String password;
    private String fullName;

    // Getters and setters (or use Lombok if you prefer)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
