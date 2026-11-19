package com.example.serviciosweb.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class Users {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private  String dataOfBirth;
    private String city;
    private String address;
    private float annualIncome;
    private int creditScore;
    private boolean hasUnpaidDebt;
    private String unpaidDebtAmount;
    private String status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Users(int id, String firstName, String lastName, String email, String phone, String dataOfBirth, String city, String address, float annualIncome, int creditScore, boolean hasUnpaidDebt, String unpaidDebtAmount, String status, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dataOfBirth = dataOfBirth;
        this.city = city;
        this.address = address;
        this.annualIncome = annualIncome;
        this.creditScore = creditScore;
        this.hasUnpaidDebt = hasUnpaidDebt;
        this.unpaidDebtAmount = unpaidDebtAmount;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(float annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public boolean isHasUnpaidDebt() {
        return hasUnpaidDebt;
    }

    public void setHasUnpaidDebt(boolean hasUnpaidDebt) {
        this.hasUnpaidDebt = hasUnpaidDebt;
    }

    public String getUnpaidDebtAmount() {
        return unpaidDebtAmount;
    }

    public void setUnpaidDebtAmount(String unpaidDebtAmount) {
        this.unpaidDebtAmount = unpaidDebtAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
