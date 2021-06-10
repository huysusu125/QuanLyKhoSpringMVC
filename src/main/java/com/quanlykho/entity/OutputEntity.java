package com.quanlykho.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Output")
public class OutputEntity extends BaseEntity{
    @OneToMany(mappedBy = "outputs")
    private List<OutputinfoEntity> outputinfoes = new ArrayList<>();

    public List<OutputinfoEntity> getOutputinfoes() {
        return outputinfoes;
    }

    public void setOutputinfoes(List<OutputinfoEntity> outputinfoes) {
        this.outputinfoes = outputinfoes;
    }
}
