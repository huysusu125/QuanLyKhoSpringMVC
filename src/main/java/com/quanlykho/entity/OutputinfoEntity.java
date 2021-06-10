package com.quanlykho.entity;

import javax.persistence.*;

@Entity
@Table(name = "outputinfo")
public class OutputinfoEntity extends BaseEntity {

    @Column(name = "count")
    private Long count;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "object_id")
    private ObjectEntity objects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_id")
    private OutputEntity outputs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customers;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ObjectEntity getObjects() {
        return objects;
    }

    public void setObjects(ObjectEntity objects) {
        this.objects = objects;
    }

    public OutputEntity getOutputs() {
        return outputs;
    }

    public void setOutputs(OutputEntity outputs) {
        this.outputs = outputs;
    }

    public CustomerEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerEntity customers) {
        this.customers = customers;
    }
}
