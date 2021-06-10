package com.quanlykho.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "suplier")
public class SuplierEntity extends BaseEntity{
    @Column(name = "displayname")
    private String DisplayName;

    @Column(name = "address")
    private String Address;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "email")
    private String Email;

    @Column(name = "contractdate")
    private Date ContractDate;

    @OneToMany(mappedBy = "suplier")
    private List<ObjectEntity> objects = new ArrayList<>();

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

    public List<ObjectEntity> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectEntity> objects) {
        this.objects = objects;
    }
}
