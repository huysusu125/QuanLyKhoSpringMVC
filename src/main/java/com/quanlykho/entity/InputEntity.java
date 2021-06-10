package com.quanlykho.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "input")
public class InputEntity extends BaseEntity{

    @OneToMany(mappedBy = "inputs")
    private List<InputinfoEntity> inputinfoes = new ArrayList<>();

    public List<InputinfoEntity> getInputinfoes() {
        return inputinfoes;
    }

    public void setInputinfoes(List<InputinfoEntity> inputinfoes) {
        this.inputinfoes = inputinfoes;
    }
}
