package com.quanlykho.converter;

import com.quanlykho.dto.OutputinfoDTO;
import com.quanlykho.entity.OutputinfoEntity;
import org.springframework.stereotype.Component;

@Component
public class OutputinfoConverter {
    public OutputinfoDTO toDTO(OutputinfoEntity entity) {
        OutputinfoDTO result = new OutputinfoDTO();
        result.setId(entity.getId());
        result.setObjectId(entity.getObjects().getId());
        result.setObjectName(entity.getObjects().getDisplayName());
        result.setCustomerId(entity.getCustomers().getId());
        result.setCustomerName(entity.getCustomers().getDisplayName());
        result.setUnitId(entity.getObjects().getUnit().getId());
        result.setUnitName(entity.getObjects().getUnit().getDisplayName());
        result.setCount(entity.getCount());
        result.setPrice(entity.getPrice());
        result.setCreatedBy(entity.getCreatedBy());
        result.setModifiedBy(entity.getModifiedBy());
        result.setCreatedDate(entity.getCreatedDate());
        result.setModifiedDate(entity.getModifiedDate());
        return result;
    }

    public OutputinfoEntity toEntity(OutputinfoDTO dto) {
        OutputinfoEntity result = new OutputinfoEntity();
        result.setCount(dto.getCount());
        result.setPrice(dto.getPrice());
        return result;
    }

    public OutputinfoEntity toEntity(OutputinfoEntity result, OutputinfoDTO dto) {
        result.setCount(dto.getCount());
        result.setPrice(dto.getPrice());
        return result;
    }
}
