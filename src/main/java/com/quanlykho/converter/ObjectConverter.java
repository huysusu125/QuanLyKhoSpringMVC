package com.quanlykho.converter;

import com.quanlykho.dto.ObjectDTO;
import com.quanlykho.entity.ObjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ObjectConverter {
    public ObjectDTO toDTO(ObjectEntity entity){
        ObjectDTO result = new ObjectDTO();
        result.setId(entity.getId());
        result.setDisplayName(entity.getDisplayName());
        result.setUnitId(entity.getUnit().getId());
        result.setUnitName(entity.getUnit().getDisplayName());
        result.setSuplierId(entity.getSuplier().getId());
        result.setSuplierName(entity.getSuplier().getDisplayName());
        result.setCreatedBy(entity.getCreatedBy());
        result.setModifiedBy(entity.getModifiedBy());
        result.setCreatedDate(entity.getCreatedDate());
        result.setModifiedDate(entity.getModifiedDate());
        return result;
    }

    public ObjectEntity toEntity(ObjectDTO dto){
        ObjectEntity result = new ObjectEntity();
        result.setDisplayName(dto.getDisplayName());
        return result;
    }

    public ObjectEntity toEntity(ObjectEntity result, ObjectDTO dto){
        result.setDisplayName(dto.getDisplayName());
        return result;
    }
}
