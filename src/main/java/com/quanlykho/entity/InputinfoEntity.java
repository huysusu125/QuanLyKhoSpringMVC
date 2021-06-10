package com.quanlykho.entity;

import javax.persistence.*;

@Entity
@Table(name = "inputinfo")
public class InputinfoEntity extends BaseEntity {
    @Column(name = "count")
    private Long count;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "object_id")
    private ObjectEntity objects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "input_id")
    private InputEntity inputs;

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

    public InputEntity getInputs() {
        return inputs;
    }

    public void setInputs(InputEntity inputs) {
        this.inputs = inputs;
    }
}
