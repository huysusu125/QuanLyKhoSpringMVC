package com.quanlykho.dto;

public class ObjectDTO extends AbstractDTO<ObjectDTO>{

    private String displayName;

    private Long unitId;

    private String unitName;

    private Long suplierId;

    private String suplierName;

    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSuplierName() {
        return suplierName;
    }

    public void setSuplierName(String suplierName) {
        this.suplierName = suplierName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getSuplierId() {
        return suplierId;
    }

    public void setSuplierId(Long suplierId) {
        this.suplierId = suplierId;
    }
}
