package com.quanlykho.dto;

import java.sql.Date;

public class CustomerDTO extends AbstractDTO<CustomerDTO> {
    private String displayName;
    private String Address;

    private String Phone;

    private String Email;

    private Date ContractDate;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
