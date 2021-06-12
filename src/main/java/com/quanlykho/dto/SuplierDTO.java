package com.quanlykho.dto;


import java.sql.Date;

public class SuplierDTO extends AbstractDTO<SuplierDTO> {
    private String DisplayName;

    private String Address;

    private String Phone;

    private String Email;

    private Date ContractDate;

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getContractDate() {
        return ContractDate;
    }

    public void setContractDate(Date contractDate) {
        ContractDate = contractDate;
    }
}
