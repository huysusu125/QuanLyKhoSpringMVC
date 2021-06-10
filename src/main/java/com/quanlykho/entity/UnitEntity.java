package com.quanlykho.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unit")
public class UnitEntity extends BaseEntity {

    @Column(name = "displayname")
    private String DisplayName;

    @OneToMany(mappedBy = "unit")
    private List<ObjectEntity> objects = new ArrayList<>();

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public List<ObjectEntity> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectEntity> objects) {
        this.objects = objects;
    }
}
