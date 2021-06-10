package com.quanlykho.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "object")
public class ObjectEntity extends BaseEntity{

    @Column(name = "displayname")
    private String DisplayName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private UnitEntity unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suplier_id")
    private SuplierEntity suplier;

    @OneToMany(mappedBy = "objects")
    private List<InputinfoEntity> inputinfoes = new ArrayList<>();

    @OneToMany(mappedBy = "objects")
    private List<OutputinfoEntity> outputinfoes = new ArrayList<>();

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }

    public SuplierEntity getSuplier() {
        return suplier;
    }

    public void setSuplier(SuplierEntity suplier) {
        this.suplier = suplier;
    }

    public List<InputinfoEntity> getInputinfoes() {
        return inputinfoes;
    }

    public void setInputinfoes(List<InputinfoEntity> inputinfoes) {
        this.inputinfoes = inputinfoes;
    }

    public List<OutputinfoEntity> getOutputinfoes() {
        return outputinfoes;
    }

    public void setOutputinfoes(List<OutputinfoEntity> outputinfoes) {
        this.outputinfoes = outputinfoes;
    }
}
